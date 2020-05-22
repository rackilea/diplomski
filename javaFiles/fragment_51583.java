@Controller
public class LoginController {
    @Autowired
    private UserRepositoryImpl userRepository;

    @RequestMapping(value = "/login", params = "btnRegister")
    public String loginRegister(@ModelAttribute Login login, Model model){
        model.addAttribute("login", login != null ? login : new Login());
        userRepository.createUser(login.getName(),login.getPassword());
        System.out.println(userRepository.findUser(login.getName()));
        return "login";
    }