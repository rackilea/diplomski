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

    public ArrayList<Question> getQuestions(User user)  {
        //gets user's questions, using the accessToken field
        //set's a user's questions field to the result and returns the result
    }

    public ArrayList<Answer> getAnswers(User user)  {
        //same as previous
    }

    public boolean sendMessage(User user)  {
        //sends a message, if current accessToken is strong
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
        return wrapper.getQuestions(this);
    }

    public ArrayList<Answer> findAnswers()  {
        return wrapper.getAnswers(this);
    }

    public boolean sendMessage()  {
        return wrapper.sendMessage(this);
    }

    // ... getters and setters ...
}