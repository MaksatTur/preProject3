package hiber.model;

import javax.persistence.*;

@Entity
@Table(catalog = "spring_hiber", name = "cars")
public class Car {

    @OneToOne(mappedBy = "car")
    private User owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "serias")
    private int serias;

    public Car(Long id, String name, int serias) {
        this.id = id;
        this.name = name;
        this.serias = serias;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerias() {
        return serias;
    }

    public void setSerias(int serias) {
        this.serias = serias;
    }

    @Override
    public String toString() {
        return "Имя машины: " + this.name + " Серия машины: " + this.serias;
    }
}
