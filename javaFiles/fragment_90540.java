@Override
public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
        throws BadLocationException {
    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
    StringBuilder sb = new StringBuilder(currentText);

    String newText = sb.replace(offset, offset + length, text).toString();