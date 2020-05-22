@RestController
public class UserController {

  @Autowired
  MyUserDetailsService userdetailservice;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public UserView home(Principal principal) {
      User user = userdetailservice.loadUserByUsername(principal.getName());
      return principal != null ? new UserView(user) : null;
  }
}