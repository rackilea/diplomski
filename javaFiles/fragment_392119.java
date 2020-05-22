@Controller
@RequestMapping("/users")
public class UserService {
    @RequestMapping("/register.do")
    public void registerUser(User user) {
        // user registration stuff
    }
}