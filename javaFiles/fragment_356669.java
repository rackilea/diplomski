import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "(\\d{4}-\\d{2}-\\d{2})[A-Z]+(\\d{2}:\\d{2}:\\d{2}).([0-9+-:]+)";
final String string = "2013-08-11T17:22:04.51+01:00";
final String subst = "\\1 \\2 \\3";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll(subst);

System.out.println("Substitution result: " + result);