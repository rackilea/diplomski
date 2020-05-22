import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "((?:\\w){8}-(?:\\w){4}-(?:\\w){4}-(?:\\w){4}-(?:\\w){12})";
final String string = "67a9854c-f63c-ef4a-0908-001fa4ff6512";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}