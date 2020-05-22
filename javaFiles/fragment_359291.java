@Controller
public class DenemeController {

    @RequestMapping("/welcome")
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Welcome back to Java Tuğrul." +
            "\nYou're right way." +
            "\nAll your time on software engineering you have to keep learn new things");

        return "hello";
    }
}