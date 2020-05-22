import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDiff {

    public static void main(String[] args) throws ParseException {

        // Setup
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd/yyyy HH:mm:ss");
        long second = 1000l;
        long minute = 60l * second;
        long hour = 60l * minute;

        // parsing input
        Date date1 = dateFormat.parse("02/26/2014 09:00:00");
        Date date2 = dateFormat.parse("02/26/2014 19:30:00");

        // calculation
        long diff = date2.getTime() - date1.getTime();

        // printing output
        System.out.print(String.format("%02d", diff / hour));
        System.out.print(":");
        System.out.print(String.format("%02d", (diff % hour) / minute));
        System.out.print(":");
        System.out.print(String.format("%02d", (diff % minute) / second));
    }

}