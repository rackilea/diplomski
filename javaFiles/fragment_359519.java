@Entity(name = "role_t")
public class Role extends BaseEntity {

    @Column(name = "role_name", nullable = false)
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // getters & setters
}