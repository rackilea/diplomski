import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "ThisIsATestStringThatIsBeingUsedInThisExample";
        System.out.println("Test String Length: " + s.length());
        Pattern p = Pattern.compile("^[A-Za-z]{32,}$");
        Matcher m = p.matcher(s);
        System.out.println("Found = " + (m.find() ? "True" : "Flase"));
        if (m.find()) {
            String str = s.substring(m.start(), m.end());
            System.out.println("Result = " + str);
        }
    }
}