JTextPane textPane = new JTextPane();
textPane.setText( "Hello:" );
textPane.setEditable(false);
StyledDocument doc = textPane.getStyledDocument();

//  Define a keyword attribute

Simple AttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setBold(keyWord, true);

//  Add some text

try
{
    doc.insertString(doc.getLength(), "\nAnother line of text", keyWord );
}
catch(Exception e) {}