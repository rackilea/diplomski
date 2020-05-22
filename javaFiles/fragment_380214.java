@Entity
public class Role {
....
 @ManyToMany
    private Set<Permission> permissions;
....


@Entity
public class Permission{
.....
@ManyToMany(mappedBy="permissions")
    private List<Role> roles;
....