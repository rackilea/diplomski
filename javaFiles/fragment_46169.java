import java.util.*;
import org.joda.time.*;
import org.joda.time.format.*;

public class Test {

  public static final String DATE_PATTERN_SERVICE = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {        
        DateTimeFormatter utcFormatter = DateTimeFormat
            .forPattern(DATE_PATTERN_SERVICE)
            .withLocale(Locale.US)
            .withZoneUTC();
        DateTimeZone indianZone = DateTimeZone.forID("Asia/Kolkata");
        DateTimeFormatter indianZoneFormatter = utcFormatter.withZone(indianZone);

        String utcText = "2015-08-23 10:34:40";
        DateTime parsed = utcFormatter.parseDateTime(utcText);
        String indianText = indianZoneFormatter.print(parsed);
        System.out.println(indianText); // 2015-08-23 16:04:40
    }
}