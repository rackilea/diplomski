private void insertMessage() {
    try {
        doc.insertString(jTextPane1.getText().length(),
           "Hi, this is StackOverflow.\n", null);
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
}