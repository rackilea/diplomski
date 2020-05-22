import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "(?<=[\\w\\d\\s.]|^)[\\w\\d\\s.].{0,3}[\\w\\d\\s.](?=[\\w\\d\\s.]|$)";
final String string = "Just a sa'mple 'String.";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}