@Controller
public class Functions {
    @RequestMapping("/")
    public String getHomepage() {
        return "index";
    }
}