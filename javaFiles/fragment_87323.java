@Component
@RepositoryEventHandler(User.class) 
public class UserEventHandler {

  @Autoware 
  private UserRepo userRepo;

  @BeforeDeleteEvent
  public void beforeDelete(User u) {
    //...
    if (/* smth. wrong */) throw new MyException(...);
  }
}