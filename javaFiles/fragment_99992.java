@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private int age;

    private Role role;

    private boolean locked;

    private long numberOfReports;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name="FOLLOWER",
            joinColumns={@JoinColumn(name="USER_ID")},
            inverseJoinColumns={@JoinColumn(name="FOLLOWER_ID")})
    private Set<User> followed = new HashSet<User>();

    @JsonIgnore
    @ManyToMany(mappedBy="followed")
    private Set<User> follower = new HashSet<User>();

   //How it was before
    @OneToMany
    @JoinColumn(name = "TRACK_ID")
    private List<Track> tracks;

   //How is it now
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<Track> tracks;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHARE_ID")
    private List<Share> shares;