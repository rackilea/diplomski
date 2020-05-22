import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^[^$@!%*?&\\n]*[$@!%*?&][^$@!%*?&\\n]*$";
final String string = "abc12312\n"
     + "$123\n"
     + "$123?\n"
     + "Alpha1?\n"
     + "@lpha1?";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}