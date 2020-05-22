import java.util.regex.Matcher;
import java.util.regex.Pattern;

String input = "...";
String regex = "value\\s*=\\s*[\"']<s:message\\s+code\\s*=\\s*[\"']([^\"']+)[\"']\\s*\\/>";

List<String> allMatches = new ArrayList<String>();
Matcher m = Pattern.compile(regex).matcher(input);

while (m.find()) {
  allMatches.add(m.group(1));
}

System.out.println(allMatches);