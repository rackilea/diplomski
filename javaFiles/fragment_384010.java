@Controller
public class MyController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "yourTemplateName";
    }
}