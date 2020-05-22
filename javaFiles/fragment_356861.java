@Controller
@RequestMapping("/secure/profile/services/export/")
public class AccountServiceProviderController extends ProfileDashboardController {

    private static final String DESC_NAME = "ACCOUNT SERVICE PROVIDER CONTROLLER";


    @RequestMapping("/getuser")
    public @ResponseBody
    JSONPObject list(@RequestParam("callback") final String callback, final HttpServletResponse response) {

        response.setContentType("text/javascript; charset=UTF-8");

        return new JSONPObject(callback, getJson());

    }

    public JSONObject getJson() {
        User user = getCurrentUser();
        JSONObject json = new JSONObject();

        // User muss eingeloggt sein
        if (user != null) {
            json.put("lname", user.getLastName());
            json.put("fname", user.getFirstName());

            logger.info("Daten werden exportiert: " + json.toString());
            return json;
        }
        return null;

    }

}