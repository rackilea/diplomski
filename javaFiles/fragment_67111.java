import java.time.LocalDateTime;

public class DateTimeSample {

  public static void main(String[] args) {
    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt);
    System.out.println(ldt.withNano(0));
  }
}