JTextPane textPane = new JTextPane();
textPane.setText("Line1");
StyledDocument doc = textPane.getStyledDocument();

//  Define the attribute you want for the line of text

SimpleAttributeSet center = new SimpleAttributeSet();
StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

//  Add some text to the end of the Document

try
{
    int length = doc.getLength();
    doc.insertString(doc.getLength(), "\ntest", null);
    doc.setParagraphAttributes(length+1, 1, center, false);
}
catch(Exception e) { System.out.println(e);}