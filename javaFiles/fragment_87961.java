import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        // Works
        DateTime dateTime = getItemDate("2011-11-19 18:29:41",
                                        "yyyy-MM-dd HH:mm:ss");

        System.out.println(dateTime);

        // Works for me too...
        dateTime = getItemDate("2011-11-19 18:29:41",
                               "YYYY-MM-dd HH:mm:ss");

        System.out.println(dateTime);
    }

    public static DateTime getItemDate(String date, String pattern) {
        return DateTimeFormat.forPattern(pattern)
            .parseDateTime(date)
                .withZone(DateTimeZone.getDefault());
    }
}