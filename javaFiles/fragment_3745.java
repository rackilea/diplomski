@Named
@RequestScoped
public class Mybean {

   private List<User> userLists; // +getters and setters
   @EJB
   private SomeService ss;

   //make the call to the Db in a PostConstruct annotated method, NOT in the constructor. So the injections are done.
   @PostConstruct
   public void init(){
      userLists = ss.getUsers();
   }
}