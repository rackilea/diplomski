import java.util.*;
import java.text.*;

public class YourCode {
    public static void main(String[] args) throws Exception {
        for (String a : args) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy hh:mm a");
            Date d = dateFormat.parse(a);
            System.out.println(d);
        }
    }
}