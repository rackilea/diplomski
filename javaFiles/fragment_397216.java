import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
          String lines = "36600.10: [Host #256] utilization is 21.65% \n 36600.10: [Host #256] utilization is 91.78% \n 36600.10: [Host #256] utilization is 3.29%";
          String pattern = "(utilization is\\s)(\\d+\\.\\d*)(.*)";

          Pattern r = Pattern.compile(pattern);

          Matcher m = r.matcher(lines);
         while (m.find()) {
             System.out.println(m.group(2));
          } 
    }

}