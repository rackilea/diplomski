@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(generator = "gen")
    @Column(name = "user_role_id", unique = true, nullable = false)
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
    private int user_role_id;
    private String authority;

}