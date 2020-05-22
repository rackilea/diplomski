import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class Example01 {
    public static void main(String[] argv) throws Exception {
        Date date = null;
        String dateValue  = "Tue, 27 Jan 2015 07:33:54 GMT";

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

        date = dateFormat.parse(dateValue);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println("date = " + dateFormat.format(date));
    }
}