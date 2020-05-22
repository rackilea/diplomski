@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public Person() {
        this.trips = new List<>();
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    ...
}