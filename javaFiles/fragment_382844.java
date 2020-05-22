import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
public class Dater {


    public static void main(String[] argv) {
       int msecs = 60*60*1000;
       SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
       formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
       String dateString = formatter.format(new Date(msecs * 1L));      
       System.out.println(dateString);
    }
}