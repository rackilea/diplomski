import org.joda.time.DateTime;

public class JodaTest {

  public static void main(String[] args) {
    DateTime dateTime = new DateTime();
    dateTime = dateTime.withMillis(1473069000000L);

    System.out.println(dateTime);
    System.out.println(new DateTime(1473069000000L));
  }
}