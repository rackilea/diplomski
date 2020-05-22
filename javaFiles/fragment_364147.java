@Entity
public class User extends Model {
    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String username;

    public void setUsername(String _username) {
        username = _username;
    }

    @Constraints.Required
    public String password;

    public void setPassword(String _password) {
        password = _password;
    }

    public static Finder<Long, User> find = new Finder<Long, User>(
        Long.class, User.class
    );
}