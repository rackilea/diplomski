@Entity
 public class User {

      @OneToMany(mappedBy="user")
      private Set<PermissionAssignation> permissions;

 }