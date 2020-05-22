@Controller
@RequestMapping("/")
public class ApplicationController {

   @RequestMapping(value="/account", method = RequestMethod.GET) 
   public String displayAccountForm(...) {
       // do whatever suits your requirements

       return "account";
   }

   @RequestMapping(value="/account", method = RequestMethod.POST) 
   public String handleSubmittedForm(...) {
       // do whatever suits your requirements

       return "successPage";
   }
}