@Component
public class BeforeSaveListener extends AbstractMongoEventListener<User> {
  // you can inject the books repository
  @Override
  public void onBeforeSave(BeforeSaveEvent<User> event) {
   // verify the books and throw exception if not valid
  }
}