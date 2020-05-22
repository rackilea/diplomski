import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;
import org.joda.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Interval interval = betweenNowAndNext(DateTimeConstants.MONDAY, new LocalTime(10, 14));
        System.out.println(interval.toDurationMillis());
    }

    public static Interval betweenNowAndNext(int dayOfWeek, LocalTime time) {
        DateTime now = DateTime.now();
        DateTime closest = time.toDateTime(now).withDayOfWeek(dayOfWeek);
        return new Interval(now, closest.isBefore(now) ? closest.plusWeeks(1) : closest);
    }
}