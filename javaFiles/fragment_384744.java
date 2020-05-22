@Entity
@Table(name = "users")
public class User implements UserDetails, Buildable<User.Builder> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String username;

    @Nullable
    @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
    @JsonUnwrapped
    private UserInfo userInfo;


    ...
}


@Entity
@Table(name = "users_info")
public class UserInfo {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private String surname;

    @OneToOne
    @MapsId
    private User user;
    ...