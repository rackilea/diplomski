import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static int dayOfWeekIWant(final String dayOfWeekIWantString)
            throws Exception {

        final int dayOfWeekIWant;

        if ("sunday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.SUNDAY;
        } else if ("monday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.MONDAY;
        } else if ("tuesday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.TUESDAY;
        } else if ("wednesday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.WEDNESDAY;
        } else if ("thursday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.THURSDAY;
        } else if ("friday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.FRIDAY;
        } else if ("saturday".equalsIgnoreCase(dayOfWeekIWantString)) {
            dayOfWeekIWant = Calendar.SATURDAY;
        } else {
            throw new Exception(
                    "Invalid input, it must be \"DAY_OF_WEEK HOUR\"");
        }

        return dayOfWeekIWant;
    }

    public static String getOrdinal(int cardinal) {
        String ordinal = String.valueOf(cardinal);

        switch ((cardinal % 10)) {
        case 1:
            ordinal += "st";
            break;
        case 2:
            ordinal += "nd";
            break;
        case 3:
            ordinal += "rd";
            break;
        default:
            ordinal += "th";
        }

        return ordinal;

    }

    public static void printDate(Calendar calendar) {
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, Locale.ENGLISH);
        String dayOfMonth = getOrdinal(calendar.get(Calendar.DAY_OF_MONTH));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        System.out.printf("%s %s %02d:%02d", dayOfWeek, dayOfMonth, hour, minute);
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);

        final int today = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("Please, input the day of week you want to know:");

        boolean inputOk = false;

        while (!inputOk)

            try {
                String input = scanner.nextLine();
                String[] split = input.split("\\s");
                String dayOfWeekIWantString = split[0];

                String[] splitHour = split[1].split(":");
                int hour = Integer.parseInt(splitHour[0]);
                int minute = Integer.parseInt(splitHour[1]);

                int dayOfWeekIWant = dayOfWeekIWant(dayOfWeekIWantString);

                int diff = (today >= dayOfWeekIWant) ? (7 - (today - dayOfWeekIWant))
                        : (dayOfWeekIWant - today);

                calendar.add(Calendar.DAY_OF_WEEK, diff);
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                inputOk = true;

            } catch (Exception e) {

                // Using a generic exception just for explanation purpose
                // You must create a specific Exception
                System.out
                        .println("Invalid input, you must enter a valid input in format: \"DAY_OF_WEEK HOUR\"");
                continue;
            }

        printDate(calendar);

    }
}