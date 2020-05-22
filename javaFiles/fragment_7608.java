import org.joda.time.*;

public class Test
{
    public static void main(String[] args)
    {
        // Defaults to current time and time zone
        DateTime now = new DateTime();
        int hour = Integer.parseInt(args[0]);

        DateTime then = now
            .withHourOfDay(hour)
            .withMinuteOfHour(0)
            .withSecondOfMinute(0);
        if (then.isAfter(now))
        {
            then = then.minusDays(1);
        }
        Period period = new Period(then, now, PeriodType.seconds());

        System.out.println("Difference in seconds: " + period.getSeconds());
    }
}