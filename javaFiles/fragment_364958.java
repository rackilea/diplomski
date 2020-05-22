import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TZ {

    public static void main(String[] args) throws ParseException {
    java.text.SimpleDateFormat sourceFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy");

    java.text.SimpleDateFormat gmtFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss zzzz");

    java.util.Date date1 = sourceFormat.parse("Mon Jul 04 00:00:00 IST 2011");

    TimeZone gmtTime = TimeZone.getTimeZone("GMT+00");

    gmtFormat.setTimeZone(gmtTime);

    System.out.println("Source date: " + date1);

    System.out.println("gmt:" + gmtFormat.format(date1));

    }
}