@Entity
@Table(name ="TRACK")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRACK_ID")
    private Long trackId;

    private String trackName;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "POINT_ID")
    private List<Point> point;

    @OneToOne
    @JoinColumn(name="TRACK_STATISTIC_ID")
    private TrackStatistic trackStatistic;

    private long numberOfLikes;

    private Date creationTime;