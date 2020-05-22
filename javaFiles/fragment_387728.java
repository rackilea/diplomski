JTextPane textPane = new JTextPane();
textPane.setText( "original text" );
StyledDocument doc = textPane.getStyledDocument();

//  Define a keyword attribute

SimpleAttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setBold(keyWord, true);

//  Add some text

try
{
    doc.insertString(0, "Start of text\n", null );
    doc.insertString(doc.getLength(), "\nEnd of text", keyWord );
}
catch(Exception e) { System.out.println(e); }