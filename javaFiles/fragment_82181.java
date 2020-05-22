@Entity
public class CarDetails {

    @Id
    @Column(name = "carId", insertable = false, updatable = false)
    private int carId; // don't bother with getter/setter since the `car` reference handles everything

    @OneToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    private String description;

    //setters & getters
}