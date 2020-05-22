import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");
        Matcher matcher = pattern.matcher("${$mat}");
        System.out.println("matcher = " + matcher);
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
        String group = matcher.group(1);
        System.out.println("group = " + group);
    }
}