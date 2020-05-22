import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "\\b\\d[^)]*\\)";
        final String string = "Programming is productive, (achieving a lot, and getting good results), it is often 1) demanding and 2) costly.\n\n"
             + "Programming is productive, (achieving a lot, and getting good results), it is often 1a b) demanding and 2a a) costly.\n\n\n"
             + "Programming is productive, (achieving a lot, and getting good results), it is often 1b) demanding and 2b) costly.\n\n"
             + "It is not supposed to match ( s s 1) \n";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }


    }
}