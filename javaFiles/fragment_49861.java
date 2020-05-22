@Entity
@Table(name = "users")
public class SecurityUser implements Serializable{  

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "type", nullable = false)
    @NotNull
    private String type;

    @Column(name = "full_name", nullable = false)
    @NotNull
    private String fullName;

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    //Gettters & Setters plus Default constructor
}