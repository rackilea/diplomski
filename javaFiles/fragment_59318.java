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
    private final Wrapper wrapper;

    public User(String username, AccessToken token, Wrapper wrapper) {
        this.user = user;
        this.token = token;
        this.wrapper = wrapper;
    }

    public List<Question> findQuestions() {
        // ... find the questions remotely ...
    }

    public ArrayList<Answer> findAnswers()  {
        // ... find the answers remotely ...
    }

    public boolean sendMessage()  {
        // ... send message remotely ...
    }

    // ... getters and setters ...
}