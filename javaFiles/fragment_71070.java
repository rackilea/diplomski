private static final String WORD_BOUNDARY = "\\b";
// edit this to suit your neds:
private static final String ALLOWED = "[^,.!\\-\\s]";
private static final String LOOKAHEAD = "(?!" + ALLOWED + ")";
private static final String LOOKBEHIND = "(?<!" + ALLOWED + ")";

public static Pattern createHighlightPattern(final String highlight) {
    final Pattern pattern = Pattern.compile(
            (Character.isLetterOrDigit(highlight.charAt(0)) 
             ? WORD_BOUNDARY : LOOKBEHIND)
            + Pattern.quote(highlight)
            + (Character.isLetterOrDigit(highlight.charAt(highlight.length() - 1))
             ? WORD_BOUNDARY : LOOKAHEAD),
            Pattern.CASE_INSENSITIVE);
    return pattern;
}