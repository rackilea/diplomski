public class MyDummyAuthenticator implements Authenticator {
    @Override
    public User authenticate(HttpServletRequest httpServletRequest) {
        return new User("mytestuser@domain.com");
    }
}