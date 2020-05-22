import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    public static void main(String[] args) {
        Pattern datePatt = Pattern.compile(".*(\\d{4}/\\d{1,2}/\\d{1,2})\\s+(\\d{1,2}:\\d{1,3}).*");
        Matcher matcher = datePatt.matcher("this internet will expires on 1397/7/16 22:300");
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

}