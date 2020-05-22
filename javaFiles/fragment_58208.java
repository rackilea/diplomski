import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String input = "1,300,000,000";
        Pattern p = Pattern.compile("\\d{1,3}(,?\\d{3})*"); // You can store this as static final
        Matcher m = p.matcher(input);
        while (m.find()) { // Go through all matches
            String num = m.group().replace(",", "");
            System.out.println(num);
            int n = Integer.parseInt(num);
            System.out.println(n);
        }
    }
}