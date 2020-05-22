@Controller
public class HomeController {

    @RequestMapping("home")
    public String home() {
        System.out.println("hi");
        return "home.jsp";
    }
 }