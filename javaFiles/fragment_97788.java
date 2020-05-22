import org.joda.time.*;
import org.joda.time.format.*;

public class Test {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis();
        String s = "2012-W12-12";
        try {
            DateTime dt = formatter.parseDateTime(s);
            System.out.println(dt);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}