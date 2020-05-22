public void insertString(FilterBypass fb, int offs,
                         String str, AttributeSet a)
    throws BadLocationException {

    if ((fb.getDocument().getLength() + str.length()) <= maxCharacters)
        super.insertString(fb, offs, str, a);
    else
        Toolkit.getDefaultToolkit().beep(); }