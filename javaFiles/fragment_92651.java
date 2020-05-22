import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import static java.time.ZoneOffset.UTC;

public class TruncateToMonth {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(UTC);
        ZonedDateTime truncatedToMonth = now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        System.out.println(truncatedToMonth);
        System.out.println(truncatedToMonth.toInstant().getEpochSecond());
    }
}