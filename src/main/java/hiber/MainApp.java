package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user = new User("User1", "Lastname1", "user1@mail.ru");
        User user1 = new User("User2", "Lastname2", "user2@mail.ru");
        User user2 = new User("User3", "Lastname3", "user3@mail.ru");
        User user3 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car = new Car("Focus", 1);
        Car car1 = new Car("Kalina", 2);
        Car car2 = new Car("Seed", 3);
        Car car3 = new Car("M5", 4);

        car.setUser(user);
        car1.setUser(user1);
        car2.setUser(user2);
        car3.setUser(user3);

        userService.add(user);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user0 : users) {
            System.out.println("Id = " + user0.getId());
            System.out.println("First Name = " + user0.getFirstName());
            System.out.println("Last Name = " + user0.getLastName());
            System.out.println("Email = " + user0.getEmail());
            System.out.println();
        }

        userService.getUserByCarModel("Kalina", 2);

        context.close();
    }
}
