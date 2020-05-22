@RestController
public class StringController extends ValidateController<String>{

   public ValidateControllerApp(Validator<String> validator){
       this.validator = validator;
   }

}