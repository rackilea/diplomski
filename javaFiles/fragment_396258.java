import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;

public class EditorPaneEx {

public static void main(String[] args) {
    JFrame frame = new JFrame();
    JEditorPane editorPane = new JEditorPane();
    editorPane.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ev) {
            if (ev.getKeyCode() == KeyEvent.VK_C
                    && (ev.getModifiers() & KeyEvent.CTRL_MASK) == KeyEvent.CTRL_MASK) {
                JEditorPane editorPane = (JEditorPane) ev.getComponent();
                int caretPos = editorPane.getCaretPosition();
                try {
                    editorPane.getDocument().insertString(caretPos,
                            "desired string", null);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    frame.add(editorPane);
    frame.pack();
    frame.setVisible(true);
}