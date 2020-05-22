public class LdapAndDatabaseAuthenticationProvider extends LdapAuthenticationProvider{

  public LdapAndDatabaseAuthenticationProvider(LdapAuthenticator authenticator, LdapAuthoritiesPopulator authoritiesPopulator) {
    super(authenticator, authoritiesPopulator);
  }

  @Override
  protected DirContextOperations doAuthentication(
      UsernamePasswordAuthenticationToken authentication) {

    log.debug("Checking if user <{}> is defined at database to use this application.", authentication.getName());

    // Here is the part we need to check in the database if user has required role to log into the application.
    // After check if user has the role, do nothing, otherwise throw exception like below example.    
    boolean canUserAuthenticate = isActiveUserExist(authentication.getName());
    log.debug("canUserAuthenticate: {}", canUserAuthenticate);

    if (!canUserAuthenticate)
      throw new DisabledException("User does not have access to Application!");

    return super.doAuthentication(authentication);
  }


  private boolean isActiveUserExist(String userId) {

  // Do your logic here are return boolean value...

  }