@Controller
public class HelloController {

   @RequestMapping("/hello")
   public String handle(ModelMap model) {
      model.addAttribute("message", "Hello World!");
      return "hello";
   }
}