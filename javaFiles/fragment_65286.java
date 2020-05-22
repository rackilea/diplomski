@Entity
@Table(name = "`user`")
public class User extends Model {

    public String name;
    public String surname;
    public String password;
    public String username;
    public Date lastlogin;
}