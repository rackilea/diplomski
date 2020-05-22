import java.text.*;
import java.util.*;

public class CalendarUtils {
    public static void main(String[] args) {
        Calendar sunday = CalendarUtils.getThisSundaysDate();
        Calendar saturday = CalendarUtils.daysFrom(sunday, 6);

        CalendarUtils.printDates(sunday, saturday);
    }

    public static Calendar getThisSundaysDate() {
        Calendar sunday = new GregorianCalendar();
        sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return sunday;
    }

    public static Calendar daysFrom(Calendar cal, int days) {
        Calendar newCal = copyCalendar(cal);
        newCal.add(Calendar.DAY_OF_YEAR, days);
        return newCal;
    }

    public static Calendar copyCalendar(Calendar cal) {
        Calendar copy = new GregorianCalendar();
        copy.setTime(cal.getTime());
        return copy;
    }

    public static void printDates(Calendar from, Calendar to) {
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMMM dd, yyyy hh:mm:ss a z");

        System.out.println(dateFormat.format(from.getTime()));
        System.out.println(dateFormat.format(to.getTime()));
    }
}