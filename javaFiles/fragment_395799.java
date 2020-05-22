import java.time.*;
import java.time.format.*;

public class Test {
    public static void main(String[] args) {
        String text = "5:45 PM";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime time = LocalTime.parse(text, format);
        System.out.println(time);
    }
}