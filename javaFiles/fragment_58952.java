import java.util.regex.*;
public class TEST {
    public static void main(String[] args) {
        String subjectString = 
        "This is a sentence. " +
        "So is \"this\"! And is \"this?\" " +
        "This is 'stackoverflow.com!' " +
        "Hello World";
        String[] sentences = null;
        Pattern re = Pattern.compile(
            "# Match a sentence ending in punctuation or EOS.\n" +
            "[^.!?\\s]    # First char is non-punct, non-ws\n" +
            "[^.!?]*      # Greedily consume up to punctuation.\n" +
            "(?:          # Group for unrolling the loop.\n" +
            "  [.!?]      # (special) inner punctuation ok if\n" +
            "  (?!['\"]?\\s|$)  # not followed by ws or EOS.\n" +
            "  [^.!?]*    # Greedily consume up to punctuation.\n" +
            ")*           # Zero or more (special normal*)\n" +
            "[.!?]?       # Optional ending punctuation.\n" +
            "['\"]?       # Optional closing quote.\n" +
            "(?=\\s|$)", 
            Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(subjectString);
        while (reMatcher.find()) {
            System.out.println(reMatcher.group());
        } 
    }
}