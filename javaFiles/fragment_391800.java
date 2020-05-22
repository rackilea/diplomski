public class UserDAO implements AdminDAO {

    public boolean addUser(User user) {
        return addUser (user.getUsername(), user.getPassword(),
                        user.getFName(), user.getLName(), user.getEmail());
    }

    public boolean addUser( 
        String username, char[] password,
        String f_name, String l_name, String email) {
        // ...
    }
}