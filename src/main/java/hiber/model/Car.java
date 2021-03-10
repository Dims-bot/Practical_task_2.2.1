package hiber.model;

import com.sun.istack.NotNull;
import sun.security.pkcs11.wrapper.Constants;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "user_id")
    protected Long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne
    @MapsId
    //@JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.setCar(this);
    }

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                //"id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
