public class Wrapper  {

   public Wrapper(...)  {
       // ... does some stuff, but DOES NOT get an access token ...
   }    

   private AccessToken getAccessToken(...)  {
       AccessToken result;
       // ... gets access token, given the auth info provided as arguments ...
       return result; 
   }

    public User findUser(String username, ...) {
        return new User(username, getAccessToken(...));
    }
}

class User  {

    private String username;
    private final AccessToken token;

    public User(String username, AccessToken token) {
        this.user = user;
        this.token = token;
    }

    // ... getters and setters ...
}