import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    static String PATTERN = "[0-9]{5}";

    static String test =    "pkill -f ./scene\r\n" + 
                            "scene killed (pid 11619)\r\n" + 
                            "scene killed (pid 31533)";

    public static void main(String[] args) {
        List<String> matches = new ArrayList<String>();

        Matcher m = Pattern.compile(PATTERN).matcher(test);

        while (m.find()) matches.add(m.group());

        System.out.println(matches);
    }
}