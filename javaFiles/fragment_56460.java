public class UserAuthorizer implements Authorizer<User> {
  @Override
  public boolean authorize(User user, String role) {
    return user != null && "ANY".equals(role)
  }
}