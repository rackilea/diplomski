@Entity
@Table(name = "roles_map")
public class RolesMap {
    @Id
    @Column(name = "RM_ID", unique = true, nullable = false)
    private int rm_id;
    @Column(name = "USERNAME_A", unique = true)
    private String username_a;
    @Column(name = "USERNAME_L", unique = true)
    private String username_l;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private int role_id;
    @ManyToOne
    @JoinColumn(name="username_u", nullable=false)
    private User rUser;

    // ... constructor(s), getters/setters, etc ...
}