import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        String text = "2016-07-05 02:14:35.0";
        DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime localDateTime = LocalDateTime.parse(text, parser);
        DateTimeFormatter printer = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.S");
        String formatted = printer.print(localDateTime);
        System.out.println(formatted); // Output 2016-07-05T02:14:35.0
    }
}