@Entity(name = "Car")
public static class Car implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @Column(name="vin", nullable = false)
    String vin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    Set<CarFactory> factories;
}

@Entity(name = "CarFactory")
public static class CarFactory implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "vin", referencedColumnName = "vin")
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