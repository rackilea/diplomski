public class LoginRequestor {
  String username, password;
  public void requestCredentials() {
    Console c = System.console();
    username = c.readLine("Please enter your username: ");
    password = c.readLine("Please enter your password: ");
  }
}

public class UiServiceImpl implements UiService {
  @Inject LoginRequestor login;
  boolean loggedIn;

  public void navigateToHomePage() {
    checkLoggedIn();
  }
  private void checkLoggedIn() {
    if (loggedIn) {
      return;
    }
    login.requestCredentials();
    String username = login.getUsername();
    String password = login.getPassword();
    // Do login
    loggedIn = ...;
  }
}