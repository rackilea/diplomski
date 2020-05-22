@Controller
@RequestMapping(value = "/activation"
public class AccountActivationController
{
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam("a") String token, ModelMap model) {
        // Connection to DB executing this query :
        // "UPDATE users SET active = true WHERE S_id = " + token

        return successful ? "activationSuccessful" : "activationError";
    }
}