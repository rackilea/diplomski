import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "\\.(?!\\d)";
final String string = ".12 . 0.123 Hi.there I am .invalid.";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}