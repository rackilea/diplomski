import java.util.*;

import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main (String[] args) {
        String text = "11/26/2012";
        DateTimeFormatter formatter =
            DateTimeFormat.forPattern("MM/dd/yyyy")
                          .withLocale(Locale.US);

        LocalDate date = formatter.parseLocalDate(text);
        System.out.println(date);
    }    
}