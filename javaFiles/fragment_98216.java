@Controller
@RequestMapping("/cms")
public class CmsController {

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }