public class NoAlphaNumFilter extends DocumentFilter {
    String notAllowed = "[A-Za-z0-9]";
    Pattern notAllowedPattern = Pattern.compile(notAllowed);
    public void replace(FilterBypass fb, int offs,
                        int length, 
                        String str, AttributeSet a)
        throws BadLocationException {

        super.replace(fb, offs, len, "", a); // clear the deleted portion

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (notAllowedPattern.matcher(Character.toString(c)).matches()) {
                // not allowed; advance counter
                offs++;
            } else {
                // allowed
                super.replace(fb, offs++, 0, Character.toString(c), a);
            }
        }
    }
}