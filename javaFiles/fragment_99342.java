public class SomeSecurityRelatedClass {

   public void authenticateUser(String username, String pass) {
      if (!passCorrect(...)) {
         LoggerFactory.getLogger("SECURITY").info("rejecting user .... //etc
      }
   }
}