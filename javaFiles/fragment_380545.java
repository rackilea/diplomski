import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class temp2 {

    public static void main(String[] args) throws ParseException {
        String s = "2012-05-08T09:10:10";
        Calendar cal = stringToCalendar(s, TimeZone.getTimeZone("GMT+0"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        System.err.println(sdf.format(cal.getTime()));
    }

    public static Calendar stringToCalendar(String strDate, TimeZone timezone) throws ParseException {
        String FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
        sdf.setTimeZone(timezone);
        Date date = sdf.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

}