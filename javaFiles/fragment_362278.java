public class User extends Model {

    public static Finder<LInteger, User> find = new Finder<Integer,User>(User.class);

    @Id
    public Integer id;

    public String name;

    @Constraints.Required
    @Constraints.Email
    public String email;

    public String password;

    @Lob
    public byte[] photo;

    public static User findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }

}