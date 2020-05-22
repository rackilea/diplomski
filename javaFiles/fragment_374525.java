@Profile("pebloc")
@Controller
public class PeblocLoginController extends LoginController {

    @Override
    @RequestMapping({ "/", "/pebloc/login"})
    public String welcome(Map<String, Object> model) {
        return "pebloc/login";
    }
}