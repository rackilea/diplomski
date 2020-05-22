@Controller
public class IndexController {

    @GetMapping(path = "/loginPage")
    public String getLoginPage() {
        return "login";
    }

}