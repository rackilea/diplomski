import static net.time4j.CalendarUnit.*;
import static net.time4j.ClockUnit.*;

// the input for creating the duration (in Joda-Time called Period)
IsoUnit[] units = {YEARS, MONTHS, DAYS, HOURS, MINUTES, SECONDS};
PlainTimestamp start = PlainDate.of(2013, 4, 11).atTime(13, 45, 21);
PlainTimestamp end = SystemClock.inLocalView().now();

// create the duration
Duration<?> duration = Duration.in(units).between(start, end);

// print the duration (here not abbreviated, but with full unit names)
String s = PrettyTime.of(Locale.US).print(duration, TextWidth.WIDE);

System.out.println(s);
// example output: 1 year, 5 months, 7 days, 3 hours, 25 minutes, and 49 seconds