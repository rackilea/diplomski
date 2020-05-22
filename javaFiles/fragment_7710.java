import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(final String[] args) {
        final Pattern pattern = 
                Pattern.compile("exportDocumentInfo_(.*)-(.*).txt");
        final String mydata =
                "exportDocumentInfo_29510309-5673-4c20-83bd-6d2303c21016-0.txt";
        final Matcher matcher = pattern.matcher(mydata);

        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}