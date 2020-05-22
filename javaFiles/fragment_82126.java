import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String text = "start. \"in quotes!\"; foo? \"more \\\" words\"; bar";

        String simpleToken = "[^.;?!\\s\"]+";

        String quotedToken =
                "(?x)             # enable inline comments and ignore white spaces in the regex         \n" +
                "\"               # match a double quote                                                \n" +
                "(                # open group 1                                                        \n" +
                "  \\\\.          #   match a backslash followed by any char (other than line breaks)   \n" +
                "  |              #   OR                                                                \n" +
                "  [^\\\\\r\n\"]  #   any character other than a backslash, line breaks or double quote \n" +
                ")                # close group 1                                                       \n" +
                "*                # repeat group 1 zero or more times                                   \n" +
                "\"               # match a double quote                                                \n";

        String regex = quotedToken + "|" + simpleToken;

        Matcher m = Pattern.compile(regex).matcher(text);

        while(m.find()) {
            System.out.println("> " + m.group());
        }
    }
}