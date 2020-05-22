package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexDriver
 * @author Michael
 * @link http://stackoverflow.com/questions/29759673/java-how-can-i-parse-and-validate-a-string-using-regex/29759694?noredirect=1#comment47651768_29759694
 * @since 4/20/2015 6:53 PM
 */
public class RegexDriver {

    public static final String PATTERN = "^(\\w+[+])?\\w+[*]\\w+[|]\\w+$";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(PATTERN);
        for (String arg: args) {
            Matcher matcher = pattern.matcher(arg);
            boolean isMatch = matcher.matches();
            System.out.println(String.format("'%s' match? %s", arg, isMatch));
        }
    }
}