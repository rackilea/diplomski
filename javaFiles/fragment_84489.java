import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class WeekdayCheck {

    public static void main(String[] args) {
        String userInput = "Sunday";
        DayOfWeek inputDayOfWeek = toDayOfWeek(userInput);
        int inputYear = 2017;
        int occurrences = 0;

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(inputYear, month, 1);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == inputDayOfWeek) {
                occurrences++;
            }
        }

        System.out.println(userInput + " is the first day of a month " + occurrences + " times in " + inputYear);
    }

    private static DayOfWeek toDayOfWeek(String dayString) {
        return DayOfWeek.valueOf(dayString.toUpperCase());
    }
}