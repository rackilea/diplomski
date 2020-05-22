@Entity
@SuppressWarnings("serial")
public class User extends Model implements BasicModel<Long>
{
    @Id
    public Long         idUser;

    @Constraints.Required
    @Column(unique=true)
    public String       mail;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Module.class)
    public List<Module> contributors;

    @JsonIgnore
    private String      password;
    @Constraints.Required
    public String       firstName;
    @Constraints.Required
    public String       lastName;

    public static Model.Finder<String, User> find = new Finder<String,User>(
            String.class, User.class);
}