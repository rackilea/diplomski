@Controller
 @RequestMapping("/authenticate")
 public class LoginController {

    @Resource
    UserDao userDao;

    @RequestMapping("/index")
    public String index() {
        System.out.println(userDao.getUser(1).getPassword());
        return "Login";
    }

 }