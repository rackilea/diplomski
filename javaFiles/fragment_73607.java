import java.util.*;
import java.text.*;

public class HelloWorld {
    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-20");
        String dayOfWeek = new SimpleDateFormat("EEEEE").format(date);
        System.out.println(dayOfWeek);
    }
}