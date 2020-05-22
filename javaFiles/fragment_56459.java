public class JWTDefaultAuthenticator implements Authenticator<JWTCredentials, User> {

  @Override
  public Optional<User> authenticate(JWTCredentials credentials) throws AuthenticationException {
    return Optional.of(new User());
  }
}