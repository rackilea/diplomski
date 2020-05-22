import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

DateTime from = LocalDate.parse("2017-07-05").toDateTimeAtStartOfDay(DateTimeZone.UTC);
DateTime to = LocalDate.parse("2017-07-08").toDateTime(new LocalTime(23, 0), DateTimeZone.UTC);

long start = from.getMillis() / 1000;
long end = to.getMillis() / 1000;