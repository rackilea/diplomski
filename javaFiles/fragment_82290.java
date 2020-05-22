import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private static final String PATTERN = "<form>(.+?)</form>";
    private static final Pattern REGEX = Pattern.compile(PATTERN);

    private static final boolean ONLY_TAG = true;

    public static void main(String[] args) {

        String text = "Hello <form><span><table>Hello Rais</table></span></form> end";
        System.out.println(getValues(text, ONLY_TAG));
        System.out.println(getValues(text, !ONLY_TAG));

    }

    private static String getValues(final String text, boolean flag) {
        final Matcher matcher = REGEX.matcher(text);
        String tagValues = null;
        if (flag) {
            if (matcher.find()) {
                tagValues = "<form>" + matcher.group(1) + "</form>";
            }

        } else {
            tagValues = text.replaceAll(PATTERN, "");
        }
        return tagValues;
    }
}