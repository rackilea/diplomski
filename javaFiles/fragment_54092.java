@RestController
public class MyModelController {
   // autowired MyModelRepository & other models repositories
   // autowire MyModelValidator as mymodelValidator

   @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
   public long save(@ModelAttribute("myModel") MyModel model, BindingResult result){
       mymodelValidator.validate(model, result);

       if(result.hasErrors()){
        // return 0
       }
       // save & return saved entity's id
   }
}