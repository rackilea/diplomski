import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JulianDateTester {

  public static void main(String[] args) {
    String julianDateString = "13359";

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyDDD");
    DateTime lcd = formatter.parseDateTime("20" + julianDateString);
    DateTime lcdWeWant = lcd.minusDays(1).hourOfDay().withMaximumValue();

    System.out.println("Input: " + julianDateString + ", formats as '" + lcd.toString());
    System.out.println("The date we want is '" + lcdWeWant.toString() + "'");
    System.out.println("The \"date\" we REALLY want is " + lcdWeWant.getMillis());

  }

}