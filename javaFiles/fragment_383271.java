import java.time.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        // Value obtained with Noda Time: should be 0199-12-31T22:00:00Z.
        long millis = -55855792800000L;
        Instant instant = Instant.ofEpochMilli(millis);
        Date date = new Date(millis);
        System.out.println(instant);
        System.out.println(date);
    }
}