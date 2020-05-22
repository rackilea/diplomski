@RestController
public class MyModelController {
   // autowired MyModelRepository & other models repositories

   @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
   public long save(MyModel model){
       // added validation here (which involves queries to both repositories
       // returned saved entity.id or failed with 0
   }
}