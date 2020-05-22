import java.util.regex.*;

public class Main {
    public static void main (String[] args) {
        String html =
                "...\n" +
                "<div class=\"ui-a\">\n" +
                "<div class=\"ui-b\">\n" +
                "    <p><strong>foo</strong></p>\n" +
                "    <p>bar</p>\n" +
                "</div>\n" +
                "<div class=\"ui-c\">\n" +
                "    <p><strong>bla</strong></p>\n" +
                "    <p>...</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"ui-a\">\n" +
                "<div class=\"ui-b\">\n" +
                "    <p><strong>foo1</strong></p>\n" +
                "    <p>bar1</p>\n" +
                "</div>\n" +
                "<div class=\"ui-c\">\n" +
                "    <p><strong>bla1</strong></p>\n" +
                "    <p>...</p>\n" +
                "</div>";

        Pattern p = Pattern.compile(
                "(?sx)                               # enable DOT-ALL and COMMENTS     \n" +
                "<div\\s+class=\"ui-a\">             # match '<div...ui-a...>'         \n" +
                "(?:(?!<strong>).)*+                 # match everything up to <strong> \n" +
                "<strong>([^<>]++)</strong>          # match <strong>...</strong>      \n" +
                "(?:(?!<p>).)*+                      # match up to <p>                 \n" +
                "<p>([^<>]++)</p>                    # match <p>...</p>                \n" +
                "(?:(?!<div\\s+class=\"ui-c\">).)*+  # match up to '<div...ui-a...>'   \n" +
                "<div\\s+class=\"ui-c\">             # match '<div...ui-c...>'         \n" +
                "(?:(?!<strong>).)*+                 # match everything up to <strong> \n" +
                "<strong>([^<>]++)</strong>          # match <strong>...</strong>      \n"
        );

        Matcher m = p.matcher(html);

        while(m.find()) {
            System.out.println("---------------");
            for(int i = 1; i <= m.groupCount(); i++) {
                System.out.printf("group(%d) = %s\n", i, m.group(i));
            }
        }
    }
}