import java.util.*;
import java.text.*;

class Test {
    public static void main (String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}