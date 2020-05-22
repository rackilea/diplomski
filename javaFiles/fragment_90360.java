@Controller
public class SomeAnnotatedController {

   @RequestMapping(method = {RequestMethod.GET}, value = "/someUrl")
   public void someMethod() {
       // do something later
   }

}