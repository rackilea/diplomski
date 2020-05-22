@Entity
@Table(name = "TRIP")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private TripDeparture departureLocation;