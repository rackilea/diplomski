import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTester {

    public static void main(String[] args) {
        Date date = Date.valueOf("2011-12-25");
        System.out.println(date);

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        System.out.println(cal.getTime());
    }
}