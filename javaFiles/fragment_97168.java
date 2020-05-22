import java.util.regex.Matcher;
import java.util.regex.Pattern;

String input = "G01 G01-I006 G01-I006-I1 G01-I006-I1-R06 G01-I006-I1-R06-F001";

final Pattern pattern = Pattern.compile("([GIRF])([0-9]{1,4})-?");
Matcher m = pattern.matcher(input);
while(m.find()) {
    System.out.println(m.group(1) + " " + m.group(2));
}