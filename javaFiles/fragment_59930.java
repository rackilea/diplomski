public class UserBean implements Serializable {
    static class UserServiceProvider {
      @Inject static UserService service;
    }

    // ... 

    public UserBean() {
      this.user = UserServiceProvider.service.findUser("kaas"); 
    }

    // ...
}