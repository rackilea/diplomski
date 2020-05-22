import java.util.regex.*;

StringBuffer ResultString = new StringBuffer();

try {
    Pattern regex = Pattern.compile("(.*)\"(.*),(.*)\"(.*)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    Matcher regexMatcher = regex.matcher(a);
    while (regexMatcher.find()) {
        try {
            // You can vary the replacement text for each match on-the-fly
            regexMatcher.appendReplacement(ResultString, "$1$2$3$4");
        } catch (IllegalStateException ex) {
            // appendReplacement() called without a prior successful call to find()
        } catch (IllegalArgumentException ex) {
            // Syntax error in the replacement text (unescaped $ signs?)
        } catch (IndexOutOfBoundsException ex) {
            // Non-existent backreference used the replacement text
        } 
    }
    regexMatcher.appendTail(ResultString);
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}