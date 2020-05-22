import org.joda.time.DateTime;
import org.joda.time.Seconds;

import actions.ValidateApplicationLicence;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Akka;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Global extends GlobalSettings {

    //ActorRef myActor = Akka.system().actorOf(new Props(ValidateApplicationLicence.class));

    @Override
    public void onStart(Application application) {

        Akka.system().scheduler().schedule(
                Duration.create(20, TimeUnit.SECONDS),
                Duration.create(5, TimeUnit.SECONDS),
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.info("After 10 sec and after EVERY 5 sec  ---    " + controllers.common.Index.getDate(null));
                    }
                },
                Akka.system().dispatcher()
        );

        Akka.system().scheduler().scheduleOnce(
                Duration.create(10, TimeUnit.MILLISECONDS),
                new Runnable() {
                    public void run() {
                        Logger.info("ON START ---    " + controllers.common.Index.getDate(null));
                    }
                },
                Akka.system().dispatcher()
        );
//      Akka.system().scheduler().schedule(
//                Duration.create(0, TimeUnit.MILLISECONDS), //Initial delay 0 milliseconds
//                Duration.create(30, TimeUnit.MINUTES),     //Frequency 30 minutes
//                myActor,
//                "tick",
//                Akka.system().dispatcher(),
//                null
//        );
    }
    public static int nextExecutionInSeconds(int hour, int minute){
        return Seconds.secondsBetween(
                new DateTime(),
                nextExecution(hour, minute)
        ).getSeconds();
    }

    public static DateTime nextExecution(int hour, int minute){
        DateTime next = new DateTime()
                .withHourOfDay(hour)
                .withMinuteOfHour(minute)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        return (next.isBeforeNow())
                ? next.plusHours(24)
                : next;
    }
}