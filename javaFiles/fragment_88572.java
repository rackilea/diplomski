import java.text.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {        
        String inputText = "Nov 10,1980";

        TimeZone utc = TimeZone.getTimeZone("UTC");

        // Or dd instead of d - it depends whether you'd use "Nov 08,1980"
        // or "Nov 8,1980" etc.
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d,yyyy",
                                                            Locale.US);
        inputFormat.setTimeZone(utc);

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd",
                                                             Locale.US);
        outputFormat.setTimeZone(utc);

        Date parsed = inputFormat.parse(inputText);
        String outputText = outputFormat.format(parsed);

        System.out.println(outputText); // 1980-11-10
    }
}