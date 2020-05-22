/**
* On gaining focus place the cursor at the start of the text.
*/
public class CursorAtStartFocusListener extends FocusAdapter {

    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        Object source = evt.getSource();
        if (source instanceof JTextComponent) {
            JTextComponent comp = (JTextComponent) source;
            comp.setCaretPosition(0);
        } else {
            Logger.getLogger(getClass().getName()).log(Level.INFO,
                    "A text component expected instead of {0}",
                    source.getClass().getName());
        }
    }
}

jTextField1.addFocusListener(new CursorAtStartFocusListener());
jComboBox1.getEditor().getEditorComponent().addFocusListener(new CursorAtStartFocusListener());
// Only one instance of CursorAtStartFocusListener needed.