public class MyAuthenticator extends Authenticator {
    final PasswordAuthentication authentication;

    public MyAuthenticator(String userName, String password) {
         authentication = new PasswordAuthentication(userName, password.toCharArray());
    }
}