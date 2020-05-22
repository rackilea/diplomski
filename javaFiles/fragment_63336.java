import akka.actor.ActorRef;
import akka.actor.Props;
import play.libs.Akka;
import play.mvc.*;

import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Application extends Controller {

    public static Result sendMail() {
        DocumentIssuedMailWrapper wrapper = new DocumentIssuedMailWrapper(new DocumentIssuedMail(), ctx()._requestHeader());

        ActorRef emailDispatcher = Akka.system().actorOf(Props.create(EmailDispatcher.class));
        Akka.system().scheduler().scheduleOnce(Duration.create(0, TimeUnit.MILLISECONDS), emailDispatcher, wrapper, Akka.system().dispatcher(), null);
        return ok("Mail sent");
    }

    public static Result someAction() {
        return ok("Some other action");
    }

}