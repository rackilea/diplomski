private static void appendToPane(JTextPane tp, String msg, Color c)
{
    StyleContext sc = StyleContext.getDefaultStyleContext();
    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

    aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
    aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

    // Get the TextPane's Document
    Document doc = tp.getDocument();
    int len = doc.getLength();
    try {
        doc.insertString(len, msg, aset);  // Use the `insertString` method of the document.
    } catch (BadLocationException e) {
        // Nothing. Using the doc length makes sure this exception isn't thrown
    }

}