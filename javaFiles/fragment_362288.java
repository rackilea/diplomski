public class FloatField extends JTextField {

    public FloatField(int cols) {
        super(cols)
    } 

    protected Document createDefaultModel() { 
        return new FloatDocument();
    } 

    static class FloatDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                          throws BadLocationException { 
            if( str == null ) 
                return;

            // Reject any string with invalid float characters.
            // TODO: this could be more sophisticated
            int len = str.length();
            for (int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                if (c != '.' && c != '-' && !Character.isDigit(c))
                    return;
            }
            super.insertString(offs, str, a);
        } 
    } 
}