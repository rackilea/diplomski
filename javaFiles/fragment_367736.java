import akka.util.Duration;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Akka;
import java.util.concurrent.TimeUnit;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {


        Akka.system().scheduler().scheduleOnce(
                Duration.create(0, TimeUnit.MILLISECONDS),
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.info("ON START ---    " + System.currentTimeMillis());
                    }
                }
        );

        Akka.system().scheduler().schedule(
                Duration.create(nextExecutionInSeconds(8, 0), TimeUnit.SECONDS),
                Duration.create(24, TimeUnit.HOURS),
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.info("EVERY DAY AT 8:00 ---    " + System.currentTimeMillis());
                    }
                }
        );
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