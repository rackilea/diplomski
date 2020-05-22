import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.FlowLayout;

public class TestWindow extends JFrame {

public TestWindow() {
    JPanel p = new JPanel(new FlowLayout());
    JLabel l = new JLabel("Temp");
    JTextField tf1 = new JTextField(10);
    JTextField tf2 = new JTextField(10);
    tf1.getDocument().addDocumentListener(new MyDocumentListener(l));
    tf2.getDocument().addDocumentListener(new MyDocumentListener(l));
    p.add(tf1);
    p.add(tf2);
    p.add(l);
    add(p);
    pack();
    setVisible(true);
}

class MyDocumentListener implements DocumentListener{

    private JLabel label;

    MyDocumentListener(JLabel label) {
        this.label = label;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        handleTextChange(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleTextChange(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        handleTextChange(e);
    }

    private void handleTextChange(DocumentEvent e) {
        try {
            label.setText(e.getDocument().getText(0,e.getDocument().getLength()));
        } catch (BadLocationException ignored) {
            //todo: handle exception properly although this should never happen
        }
    }
}

public static void main(String[] args) {
    new TestWindow();
}

}