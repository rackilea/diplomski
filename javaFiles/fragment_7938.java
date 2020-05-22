@Controller
    public class DispensaryController {

       @RequestMapping(value = "/test", method = RequestMethod.GET)
       public String dispensary(Model model) {
         // This can be used in the jsp as ${name} when you access it.
         model.addAttribute("name", "Santosh");
         return "testPage";
       }
    }