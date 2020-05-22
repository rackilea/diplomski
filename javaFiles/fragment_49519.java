import java.util.regex.Pattern;
import java.util.regex.Matcher;
String str = "....";
Pattern varPattern = Pattern.compile("^.*?:(.*),.*?:(.*),.*?:(.*)$");
Matcher varMatcher = varPattern.matcher(str);
while(varMatcher.find()) {
    //do something with varMatcher.group(1)
}