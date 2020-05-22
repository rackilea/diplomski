public class Parsing {
    public static void main (final String[] args) {

        final String regexp = "([@#][a-z]+)";
        final Pattern pattern = Pattern.compile(regexp);
        final String input = "#hello#adam@how@are@you";

        final Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}