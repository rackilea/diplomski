@Controller
public class HomePageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(ModelMap map) {
        map.addAttribute("mgs", "Hello, Have a nice day");
        return "index";
    }
}