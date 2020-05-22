@Entity
@Table(name = "authority_role")
public class AuthorityEntity implements Serializable {

    private Integer id;
    private String authority;
    private List<UserEntity> people;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String authString) {
        authority = authString;
    }

    @Column(name = "authority", nullable = false)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(targetEntity = UserEntity.class,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "authority_role_people",
    joinColumns =
    @JoinColumn(name = "authority_role_id"),
    inverseJoinColumns =
    @JoinColumn(name = "user_id"))
    public List<UserEntity> getPeople() {
        return people;
    }

    public void setPeople(List<UserEntity> people) {
        this.people = people;
    }
}