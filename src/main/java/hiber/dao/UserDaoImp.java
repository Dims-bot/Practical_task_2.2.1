package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCarModel(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select user from Car as car inner join User user on car.id = user.id " +
                "where car.model = :model and car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }

//select u.*, c.model, c.series from car c inner join users u on c.user_id = u.id where c.model = 'Kalina';
//select u.* from car c inner join users u on c.user_id = u.id where c.model = 'Kalina';
}
