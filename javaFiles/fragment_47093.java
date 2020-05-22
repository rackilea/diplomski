import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<String> monthList = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec");
        int[] months = new int[12];
        String[] dateStrs = { "Feb 14, 2020, 8:03 pm", "Jan 20, 2020, 9:03 am", "Mar 6, 2020, 2:03 pm",
                "Feb 15, 2020, 11:03 am", "Jul 18, 2020, 4:03 am", "Jan 21, 2020, 5:03 pm", "Mar 11, 2020, 6:03 pm" };
        for (String dateStr : dateStrs) {
            months[monthList.indexOf(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm a"))
                    .getMonth().getDisplayName(TextStyle.SHORT, Locale.US))]++;
        }
        for (int i = 0; i < months.length; i++) {
            System.out.println(monthList.get(i) + ":" + months[i]);
        }

        //Similarly apply the following format for the second CSV file
        // DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssXX")
        // String[] dateStr2 = {"2020-01-20T16:34:57+0800",...};            
    }
}