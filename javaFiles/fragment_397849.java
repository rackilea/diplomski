@Controller
public class ProfileController {
@Autowired
private LoginController loginControllerObj;
@RequestMapping(value = "/getUserData", method = RequestMethod.GET,produces = "application/json")
public @ResponseBody Map<String, String> getUser(HttpServletRequest req) throws Exception {
    try{


        String loggedInUser=loginControllerObj.getUserName();

        System.out.println("UserName is  "+ loggedInUser);