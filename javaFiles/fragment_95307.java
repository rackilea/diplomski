@Entity
public class User{

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    public List<UserRole> userRoles;
}

@Entity
public class UserRole{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "given_by")
    private String givenBy;
}

@Entity
public class Role{

    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;
}