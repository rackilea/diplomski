import models.LocalUser;
import play.Logger;
import securesocial.core.Authenticator;
import securesocial.core.IdentityId;
import securesocial.core.SocialUser;
import securesocial.core.PasswordInfo;
import scala.Some;
import securesocial.core.AuthenticationMethod;
import scala.Option;
import scala.util.Right;
import scala.util.Either;
import play.mvc.Http.Cookie;

public class Utils {


    public static Cookie fakeCookie(String user){

        LocalUser localUser = LocalUser.findByEmail(user);
        Logger.debug("Username: " + localUser.username +" - ID: " + localUser.id);

        SocialUser socialUser = new SocialUser(new IdentityId(localUser.id, localUser.provider),    
            localUser.firstName, 
            localUser.lastName, 
            String.format("%s %s", localUser.firstName, localUser.lastName),
            Option.apply(localUser.email), 
            null, 
            new AuthenticationMethod("userPassword"),
            null, 
            null, 
            Some.apply(new PasswordInfo("bcrypt", localUser.password, null))
        );  

        Either either = Authenticator.create(socialUser);
        Authenticator auth = (Authenticator) either.right().get();
        play.api.mvc.Cookie scalaCookie = auth.toCookie();


        //debug loggig
        Logger.debug("Cookie data:");
        Logger.debug("Name: " + "Value: " + auth.cookieName() + " | Class: " + auth.cookieName().getClass() + " | Should be type: " + "java.lang.String");
        Logger.debug("Value: " + "Value: " + scalaCookie.value() + " | Class: " + scalaCookie.value().getClass() + " | Should be type: " + "java.lang.String");
        Logger.debug("MaxAge: " + "Value: " + scalaCookie.maxAge() + " | Class: " + scalaCookie.maxAge().getClass() + " | Should be type: " + "int");
        Logger.debug("Path: " + "Value: " + scalaCookie.path() + " | Class: " + scalaCookie.path().getClass() + " | Should be type: " + "java.lang.String");
        Logger.debug("Domain: " + "Value: " + scalaCookie.domain() + " | Class: " + auth.cookieDomain().getClass() + " | Should be type: " + "java.lang.String");
        Logger.debug("Secure: " + "Value: " + auth.cookieSecure() + " | Class: " + "Boolean" + " | Should be type: " + "boolean");
        Logger.debug("HttpOnly: " + "Value: " + auth.cookieHttpOnly() + " | Class: " + "Boolean" + " | Should be type: " + "boolean");

        // secureSocial doesnt seem to set a maxAge or Domain so i set them myself.
        Cookie fakeCookie = new Cookie(auth.cookieName(), scalaCookie.value(), 120, scalaCookie.path(), "None", auth.cookieSecure(), auth.cookieHttpOnly());
        return fakeCookie;
    }
}