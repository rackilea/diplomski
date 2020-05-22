import java.util.regex.*;

Pattern pattern = Pattern.compile("\\d+(?=([\\|\\s\\r\\n]))");
Matcher matcher = pattern.matcher(yourString);
while (matcher.find()) {
    System.out.println(matcher.group());
}