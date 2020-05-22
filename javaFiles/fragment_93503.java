public void append(Color c, String s) { // better implementation--uses StyleContext

    StyleContext sc = StyleContext.getDefaultStyleContext();
    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                                    StyleConstants.Foreground, c);

    int len = getDocument().getLength(); // same value as getText().length();
    setCaretPosition(len);  // place caret at the end (with no selection)
    setCharacterAttributes(aset, false);
    replaceSelection(s); // there is no selection, so inserts at caret
}