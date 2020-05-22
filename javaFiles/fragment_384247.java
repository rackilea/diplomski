import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Launcher
{
    public static void main(String[] args)
    {
        Calendar start = new GregorianCalendar(2016, 4, 12, 0, 0, 0);
        Calendar end = new GregorianCalendar(2016, 4, 17, 0, 0, 0);

        Period period = new Period(start.getTimeInMillis(), end.getTimeInMillis());

        PeriodFormatter runDurationFormatter = new PeriodFormatterBuilder().printZeroAlways()
            .minimumPrintedDigits(2)
            .appendHours().appendSeparator(":")    // <-- say formatter to emit hours
            .appendMinutes().appendSeparator(":")  // <-- say formatter to emit minutes
            .appendSeconds()                       // <-- say formatter to emit seconds
            .toFormatter();

        // here we are expecting the following result string 120:00:00
        System.out.println(
            runDurationFormatter.print(period.normalizedStandard(PeriodType.time()))
        );
    }
}