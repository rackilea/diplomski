public class MyTextField extends JTextField {

    //final value for maximum characters
    private final int MAX_CHARS = 20;

    /**
     * A regex value which helps us to validate which values the user can enter in the input
     */
    private final String REGEX = "^[\\d\\+\\/\\*\\.\\- \\(\\)]*$";

    public MyTextField(){

        //getting our text as a document
        AbstractDocument document = (AbstractDocument) this.getDocument();        

        /**
         * setting a DocumentFilter which helps us to have only the characters we need
         */
        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0, fb.getDocument().getLength());
                text += str;

                if ((fb.getDocument().getLength() + str.length() - length) <= MAX_CHARS && text.matches(REGEX)){
                    super.replace(fb, offs, length, str, a);
                } 
            }

            public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0, fb.getDocument().getLength());
                text += str;

                if ((fb.getDocument().getLength() + str.length()) <= MAX_CHARS && text.matches(REGEX)){
                    super.insertString(fb, offs, str, a);
                }
            }
        });
    }

}