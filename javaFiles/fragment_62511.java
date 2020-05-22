import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String REGEX_START = Pattern.quote("{{");
    public static final String REGEX_END = Pattern.quote("}}");
    public static final Pattern PATTERN = Pattern.compile(REGEX_START + "(.*?)" + REGEX_END);

    public static void main(String[] args) {
        String input = "kksdkjhsd {{one}} sdkjhsdjksd {{two}}";
        List<String> keywords = new ArrayList<>();

        Matcher matcher = PATTERN.matcher(input);

        // Check for matches
        while (matcher.find()) {
            keywords.add(matcher.group(1)); // Group one is necessary because of the brackets in the pattern
        }

        // Print
        keywords.forEach(System.out::println);
    }
}