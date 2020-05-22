import java.net.Authenticator;
import java.net.PasswordAuthentication;

class MyAuthenticator extends Authenticator
   {
   /**
   * Called when password authorization is needed.
   * @return The PasswordAuthentication collected from the
   * user, or null if none is provided.
   */
   protected PasswordAuthentication getPasswordAuthentication()
      {
      return new PasswordAuthentication ( "username", "password".toCharArray() );
      }
   }