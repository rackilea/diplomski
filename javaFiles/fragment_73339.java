public class AuthService {
   private static AuthService myInstance;

   private User currentUser;
   ...

   private AuthService() {
       // Constructor is private. The Object can only be instanciated by getInstance()
   }

   public static AuthService getInstance() {
      if (myInstance == null) {
         myInstance = new AuthService();
      }

      return myInstance;
   }

   public User getCurrentUser()
   ...


   public void setLoggedInUser(User user)
   ...

   public User login(String userName, String password)
   ...

}