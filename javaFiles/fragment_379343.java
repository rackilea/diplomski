@Entity(name = "Car")
public static class Car implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @Column(name="transmission", nullable = false)
    String transmission;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    Set<CarFactory> factories;
}

@Entity(name = "Factory")
public static class Factory  implements Serializable {

    @Id
    @GeneratedValue
    long id;
}

@Entity(name = "CarFactory")
public static class CarFactory implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "transmission", referencedColumnName = "transmission")
    Car car;

    @ManyToOne
    @Id
    Factory factory;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}