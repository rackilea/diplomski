import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Answer {
    public static void main(String args[]) throws ParseException {
        // parse the date and time
        String input = "Wed May 24 15:54:40 CEST 2017";
        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        Date date = parser.parse(input);

        // parse just the date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("CEST"));

        String formattedDate = formatter.format(date);

        Date parsedDate = formatter.parse(formattedDate);

        System.out.println(parsedDate);

        // use https://currentmillis.com/ to check the milliseconds figures
        System.out.println("Wed May 24 15:54:40 CEST 2017 in milliseconds \t" + date.getTime());

        System.out.println("Wed May 24 00:00:00 CEST 2017 in milliseconds \t" + parsedDate.getTime());
     }
 }