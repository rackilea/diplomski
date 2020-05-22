import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Test extends JFrame {

    private JTextField textField;
    private JLabel label;

    void createAndShowGUI() {

        textField = new JTextField("TextField");
        this.getContentPane().add(textField, BorderLayout.CENTER);
        label = new JLabel("Label");
        this.getContentPane().add(label, BorderLayout.SOUTH);

        textField.getDocument().addDocumentListener(new MyDocumentListener(label));

        this.setSize(512, 128);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().createAndShowGUI());
    }

}

class MyDocumentListener implements DocumentListener {

    private JLabel targetComponent;

    public MyDocumentListener(JLabel component) {
        this.targetComponent = component;
    }

    private void update(DocumentEvent e) {
        try {
            targetComponent.setText(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        update(e);
    } 
}