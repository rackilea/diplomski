public interface UserService {
    User getUserByUsername(String username);
    void storeUser(User user);
    List<User> findAllUsers();
}

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService { ... }