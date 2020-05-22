import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        int year = 2012;
        int month = 4;

        /* The format string for how the dates will be printed. */
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        /* Create a calendar for the first of the month. */
        GregorianCalendar calendar = new GregorianCalendar(year, month, 1);

        /* Loop through the entire month, day by day. */
        while (calendar.get(GregorianCalendar.MONTH) == month) {
            String dateString = format.format(calendar.getTime());
            System.out.println(dateString);

            calendar.add(GregorianCalendar.DATE, 1);
        }
    }
}