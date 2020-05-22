import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class StackOverflowTest {
  public static void main(String[] args){

    ZonedDateTime dateTime1 =
       ZonedDateTime.parse("2020-01-22T08:07:59.179-08:00")
      .withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

    ZonedDateTime dateTime2 = // I'm at CET
       ZonedDateTime.parse("2020-01-22T08:07:59.179+01:00")
      .withZoneSameInstant(ZoneId.of("Europe/Berlin"));

    System.out.println(dateTime1.format(DateTimeFormatter
                                       .ofPattern("yyyy-MM-dd HH:mm:ss.SSS z")));
    System.out.println(dateTime2.format(DateTimeFormatter
                                       .ofPattern("yyyy-MM-dd HH:mm:ss.SSS z")));

/* prints
2020-01-22 08:07:59.179 GMT-08:00
2020-01-22 08:07:59.179 CET
*/
  }
}