if (e.getKeyCode() == KeyEvent.VK_C &&
       (e.getModifiers() & KeyEvent.CTRL_MASK) == KeyEvent.CTRL_MASK) {
    JEditorPane editorPane = (JEditorPane) e.getComponent();
    int caretPos = editorPane.getCaretPosition();
    try {
        editorPane.getDocument().insertString(caretPos, "desired string", null);
    } catch(BadLocationException ex) {
        ex.printStackTrace();
    }
}