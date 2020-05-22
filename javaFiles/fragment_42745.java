import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        new Main().findEmails("bob@home.com, \"Jane\" <jane@home.com>, \"Smith, Mr\" <smith@home.com>");
    }
    public void findEmails(String s) {
        System.out.println("ready: "+s);
        Pattern p = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b",
                                    Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        while (m.find())
            System.out.println("Found: "+m.group());
    }
}