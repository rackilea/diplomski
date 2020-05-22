import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Lat ([-0-9.]*) and Lon ([-0-9.]*)");
        checkMatch(pattern, "Lat 34.8.2 and Lon -174.2"); 
        checkMatch(pattern, "Lat -34.4 and Lon 174"); 
    }

    private static void checkMatch(Pattern pattern, String latAndLong) {
        Matcher matcher = pattern.matcher(latAndLong);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1)); 
        System.out.println(matcher.group(2));
    }
}