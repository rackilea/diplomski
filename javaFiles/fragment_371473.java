JTextPane textPane = new JTextPane();
StyledDocument doc = textPane.getStyledDocument();

Style style = textPane.addStyle("Style", null);
StyleConstants.setForeground(style, Color.red);
String word = "Hello";

if (word.equals("Hello")) {
    try {
        doc.insertString(doc.getLength(), word, style);
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
} else {
    StyleConstants.setForeground(style, Color.blue);

    try {
        doc.insertString(doc.getLength(), word, style);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}