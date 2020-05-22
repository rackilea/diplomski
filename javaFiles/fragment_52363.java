JTextPane textPane = new JTextPane();
textPane.setText("Some text for the text pane.");
StyledDocument doc = textPane.getStyledDocument();

SimpleAttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setBold(keyWord, true);

// Color existing text

doc.setCharacterAttributes(0, 5, keyWord, false);

// Add some text

try
{
    doc.insertString(doc.getLength(), "\nEnd of text", keyWord );
}
catch(Exception e) { System.out.println(e); }