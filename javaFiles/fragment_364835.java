public class UserLogger extends FluentLogger {

  public UserLogger forUser(Object userId) {
    return super.log("User %s");
  }
...
}