import java.util.regex.Matcher;
import java.util.regex.Pattern;

String EXAMPLE_TEST = "......";
Pattern pattern = Pattern.compile("(?<=title=\")(\\S+)")
Matcher matcher = pattern.matcher(EXAMPLE_TEST);
while (matcher.find()) {
  System.out.println(matcher.group());
}