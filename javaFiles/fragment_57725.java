import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "^(love (.*?) way you (.*?))$";
        final String string = "love the way you lie";

        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}