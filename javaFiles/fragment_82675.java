@Entity
@IdClass(TripId.class)
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    private long trip_no;

    private String state;

    @ManyToOne
    private Person person;

    public Trip() {

    }

    public Trip(String state, long trip_no, Person person) {
        this.state = state;
        this.trip_no = trip_no;
        this.person = person;
    }

    ...
}