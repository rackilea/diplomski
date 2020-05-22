import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class WeekDays {
    public static void main(String[] args) {
        final LocalDate start = new LocalDate(2014, 1, 1);
        final LocalDate end = new LocalDate(2014, 1, 14);

        LocalDate weekday = start;

        if (start.getDayOfWeek() == DateTimeConstants.SATURDAY ||
                start.getDayOfWeek() == DateTimeConstants.SUNDAY) {
            weekday = weekday.plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);
        }

        int weekdayCount = 1;
        while (weekday.isBefore(end)) {
            weekdayCount++;
            System.out.println(weekday);

            if (weekday.getDayOfWeek() == DateTimeConstants.FRIDAY)
                weekday = weekday.plusDays(3);
            else
                weekday = weekday.plusDays(1);
        }

        System.out.println(weekdayCount);
    }
}