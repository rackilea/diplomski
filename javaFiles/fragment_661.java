import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateCompare {

    public static void main(String[] args) {
        try {
            final String start = "Mon 17:00";
            final String end = "Tue 5:00";
            SimpleDateFormat formatter = new SimpleDateFormat("EEE HH:mm", Locale.US);
            long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(formatter.parse(end).getTime() - formatter.parse(start).getTime()); 
            System.out.println(diffMinutes + " minutes");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

}