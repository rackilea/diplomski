@Controller
public class HelloController implements HelloOperations {

   @Override
   public Single<String> helloBody(String name, String text)  {

     // do something in here...
   }
}