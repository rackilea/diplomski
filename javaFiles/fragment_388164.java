@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping
    public String omg(@RequestParam("name") String name, Model model) {
        try {
            model.addAttribute("name", name);
            throw new Exception("OMG!");
        } catch (Exception e) {
            model.addAttribute("myException", e);
        }
        return "/WEB-INF/foo.jsp";
    }

}