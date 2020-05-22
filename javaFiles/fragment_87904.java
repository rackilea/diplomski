public class ApiRestBasicAuthentication extends BasicAuthenticator {

  private UserAuthentication authentication = new UserAuthentication();

  public ApiRestBasicAuthentication(String realm) {
    super(realm);
  }

  @Override
  public Authenticator.Result authenticate(HttpExchange exch) {
      Authenticator.Result result=super.authenticate(exch);
      if(result instanceof Authenticator.Success) {
          HttpPrincipal principal=((Authenticator.Success)result).getPrincipal();
          String requestMethod=exch.getRequestMethod();       
          if( ADD SOME LOGIC HERE FOR PRINCIPAL AND REQUEST METHOD) {
              return new return new Authenticator.Failure(401);
          }
          return result;

      }
  }

  @Override
  public boolean checkCredentials(String user, String pwd) {
    int authCode = authentication.authenticate(user, pwd);
    return authCode == UserAuthentication.USER_AUTHENTICATED;
  }

}