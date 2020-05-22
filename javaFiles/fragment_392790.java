@Entity
@Table(name = "users")
public class User 
{



    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotAudited
    private Set<Role> roles = new HashSet<>();





}