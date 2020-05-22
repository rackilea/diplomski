import java.util.regex.Matcher;
import java.util.regex.Pattern;
...
// Find all the words of "foo bar".
Matcher m = Pattern.compile("\\w+").matcher("foo bar");
while (m.find()) {
    System.out.println("Found: " + m.group(0));
}