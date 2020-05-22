@RequestScoped
@Named
public class AuthenticatorSelector {

   @Inject Instance<CustomAuthenticator> customAuthenticator;
   @Inject Instance<IdmAuthenticator> idmAuthenticator;

   private String authenticator;

   public String getAuthenticator() {

      return authenticator;
    }

   public void setAuthenticator(String authenticator) {
      this.authenticator = authenticator;
   }

   @Produces
   @PicketLink
   public Authenticator selectAuthenticator() {
       if ("custom".equals(authenticator)) {
           return customAuthenticator.get();
        } else {
           return idmAuthenticator.get();
        }
   }
 }