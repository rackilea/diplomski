import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

            XMLGregorianCalendar xmlDate = new XMLGregorianCalendarImpl();
            xmlDate.setMonth(12);
            xmlDate.setDay(31);
            xmlDate.setYear(2019);
            xmlDate.setHour(0);
            xmlDate.setMinute(0);
            xmlDate.setSecond(0);
            Calendar calendar = xmlDate.toGregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = calendar.getTime();
           String ds1 = dt.toString();
           System.out.println("ds1 = " + ds1);
           String dateString = formatter.format(calendar.getTime());
           System.out.println("dateString = " + dateString );

    }
}