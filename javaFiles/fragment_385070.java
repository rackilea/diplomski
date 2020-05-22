@Entity
@Table(name="user")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PK_USER_ID")
    private Integer userId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "user")
    private Set<DeviceInfo> deviceInfos;
}