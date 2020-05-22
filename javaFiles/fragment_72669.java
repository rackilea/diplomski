@RestController
@RequestMapping("my/path")
public class MyController {

   @RequestMapping("/")
   public InputState myMethod() {
     ...
   }
}