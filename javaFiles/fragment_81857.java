import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        String str = "Jan(COMPANY) &^% Feb(ASP) 567 Mar(INC)";

        ArrayList<String> monthArr = new ArrayList<String>();
        ArrayList<String> dataArr  = new ArrayList<String>();

        // Part 1: \\b(\\p{Alpha}+): Word boundary, one or more characters
        // Part 2: \\(([^)]+)\\): "(", anything but ")" one or more times, ")" 
        Pattern p = Pattern.compile("\\b(\\p{Alpha}+)\\(([^)]+)\\)");
        Matcher m = p.matcher(str);

        while (m.find()) {
            monthArr.add(m.group(1));  // m.group(1) = "Jan", "Feb" and so on
            dataArr.add(m.group(2));   // m.group(2) = "COMPANY, "ASP", and so on
        }

        String[] one = monthArr.toArray(new String[0]);
        String[] two = dataArr.toArray(new String[0]);
    }
}