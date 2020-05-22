import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testmain {

    public static void main(String[] args) {
        String someString = "FAIL: some random message with ID_temptemptemp and with original ID_1234567890";
        Pattern pattern3 = Pattern.compile("ID_(\\d+)");
        Matcher matcher3 = pattern3.matcher(someString);
        String s = null; 
        while (matcher3.find()) {
            s = matcher3.group(1); // Keep overriding until the last set of captured value
        }
        System.out.println(s);
    }
}