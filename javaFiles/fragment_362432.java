import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String args[])
    {
        LocalDateTime date = LocalDateTime.now(ZoneId.of("CET"));
        System.out.println(date);

        LocalDateTime utcdate = cetToUtc(date);
        System.out.println(utcdate);

        LocalDateTime cetdate = utcToCet(utcdate);
        System.out.println(cetdate);
    }

    public static LocalDateTime cetToUtc(LocalDateTime timeInCet) {
        ZonedDateTime cetTimeZoned = ZonedDateTime.of(timeInCet, ZoneId.of("CET"));
        return cetTimeZoned.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    }

    public static LocalDateTime utcToCet(LocalDateTime timeInUtc) {
         ZonedDateTime utcTimeZoned = ZonedDateTime.of(timeInUtc,ZoneId.of("UTC"));
         return utcTimeZoned.withZoneSameInstant(ZoneId.of("CET")).toLocalDateTime();
     }
}