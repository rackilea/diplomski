import java.util.*;
import java.text.*;

public class HelloWorld {
    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("EEEEE").format(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-20")));
    }
}