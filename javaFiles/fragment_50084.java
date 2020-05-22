import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTest {


   public static void main(String[] args) throws Exception {
      String datetimeString = "Tue Apr 10 15:19:06 CEST 2018";

      String from_format = "E MMM dd HH:mm:ss z yyyy";
      String to_format = "yyyy-MM-dd";

      DateTimeFormatter from_formatter = DateTimeFormatter.ofPattern(from_format);
      DateTimeFormatter to_formatter = DateTimeFormatter.ofPattern(to_format);

      LocalDateTime ldt = LocalDateTime.parse(datetimeString, from_formatter);

      System.out.println(ldt.format(to_formatter));
   }
}