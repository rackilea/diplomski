@Controller
@RequestMapping("/test")
public class DemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String firstMethod(Model model) {
        model.addAttribute("name", "Olivier");
        return "firstPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/demo", "/demo1"})
    public String secondMethod(Model model) {
        model.addAttribute("name", "Olivier");
        return "secondPage";
    }
}