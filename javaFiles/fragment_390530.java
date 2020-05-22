@Entity
@IdClass(PermissionAssignation.class)
public class PermissionAssignation {

     @Id
     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;

     @Id
     @ManyToOne
     @JoinColumn(name="project_id")
     private Project project;

     @Id
     @ManyToOne
     @JoinColumn(name="permission_id")
     private Permission permission;
     ...
}