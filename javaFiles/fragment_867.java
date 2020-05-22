public enum RoleEnum {

    ADMIN, USER, SUPER_USER

}

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "f_pid")
    private Long pid;

    @Column(name = "f_role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}

@Entity
@Table(name = "systems")
public class SomeSystem {

    @Id
    @GeneratedValue
    @Column(name = "f_pid")
    private Long pid;

    @Column(name = "f_name")
    private String name;

}

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "f_pid")
    private Long pid;

    @Column(name = "f_user_name")
    private String userName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_role") })
    private List<Role> roles = new ArrayList<Role>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "system_assign", joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_system") })
    private List<SomeSystem> systems = new ArrayList<SomeSystem>();

}