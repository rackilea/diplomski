import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeekdayCheck {

    public static void main(String[] args) {
        String weekday = "Sunday";
        int year = 2017;
        int occurrences = 0;

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, 1);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH).equals(weekday)) {
                occurrences++;
            }
        }

        System.out.println(weekday + " is the first day of a month " + occurrences + " times in " + year);
    }
}