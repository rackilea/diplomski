import java.util.regex.*;

public class Regex {
        private static final String text = ".jar!";

        private static final String regex = "\\.jar(?=!)";

        public static void main(String[] args) {
                Pattern pat = Pattern.compile(regex, Pattern.DOTALL);
                Matcher matcher = pat.matcher(text);
                if (matcher.find()) {
                        System.out.println("Match: " + matcher.group());
                } else {
                        System.out.println("No match.");
                }
        }
}