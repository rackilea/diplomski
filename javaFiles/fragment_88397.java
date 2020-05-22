SimpleAttributSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setBold(keyWord, true);

try
{
    doc.insertString(doc.getLength(), "\nSome more text", keyWord );
}
catch(Exception e) {}