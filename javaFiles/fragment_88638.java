public static void gotoStartOfLine(JTextComponent component, int line)
{
    Element root = component.getDocument().getDefaultRootElement();
    line = Math.max(line, 1);
    line = Math.min(line, root.getElementCount());
    int startOfLineOffset = root.getElement( line - 1 ).getStartOffset();
    component.setCaretPosition( startOfLineOffset );
}