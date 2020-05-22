import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class scratch {
    public static void main (String args[]) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone (TimeZone.getTimeZone ("IST"));
        System.out.println ("Time in IST is " + sdf.format (now));
    }
}