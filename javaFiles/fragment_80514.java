import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {
    public static void main(String[] args) {
        try{
            Pattern pattern = Pattern.compile(args[1]);
            Matcher matcher = pattern.matcher(args[2]);

            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group() + ", position " + matcher.start() + ":" + matcher.end() + "\n");
                found = true;
            }
            if (!found) {
                System.out.println("\nNo match found.");
                System.exit(1);
            }
        }
        catch (Exception e) {
            System.out.println("\nCaught an exception. Description: " + e.getMessage());
            System.exit(2);
        }
    }
}