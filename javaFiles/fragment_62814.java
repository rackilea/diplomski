import java.util.regex.Pattern;
import java.util.regex.Matcher;  

public static int matches(String str, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(str);
    return matcher.matches() ? 1 : 0;
};