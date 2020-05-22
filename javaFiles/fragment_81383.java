@Component
@RepositoryEventHandler 
public class UserEventHandler {

  private final UserServie userServie;

  public UserEventHandler(UserServie userServie) {
      this.userServie = userServie;
  }

  @HandleAfterCreate
  public void handleAfterCreateUser(User user) {
      userService.afterCreate(user)  
  }

  @HandleAfterSave
  public void handleAfterSaveUser(User user) {
      userService.afterSave(user)  
  }
}