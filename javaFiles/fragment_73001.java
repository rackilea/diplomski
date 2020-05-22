import static com.test.util.RequestMappingConstants.SECURITY_CONTROLLER_PATH

@Controller
@RequestMapping("/" + SECURITY_CONTROLLER_PATH + "/*")
public class SecurityController {
  etc

  //for instance, to resuse the value as a base for the folder resolution     
  public String RESOURCE_FOLDER = SECURITY_CONTROLLER_PATH + "/";

  @RequestMapping(value="/signin-again", method = RequestMethod.GET)
    public String signinAgainHandler() {
        return RESOURCE_FOLDER + "signin_again";
    }
}