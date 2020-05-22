import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextLabelMirror {

    private JPanel mainPanel = new JPanel();
    private JPasswordField field = new JPasswordField(20);
    private JLabel label = new JLabel();
    private JLabel labelLength = new JLabel();
    private JProgressBar progressBar = new JProgressBar(0, 20);

    public TextLabelMirror() {
        field.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            private void updateLabel(DocumentEvent e) {
                String text = field.getText();//just example getText() is Depreciated !!!
                label.setText(text);
                labelLength.setText(" Psw Lenght -> " + text.length());
                if (text.length() < 1) {
                    progressBar.setValue(0);
                } else {
                    progressBar.setValue(text.length());
                }
            }
        });
        mainPanel.setLayout(new GridLayout(4, 0, 10, 0));
        mainPanel.add(field);
        mainPanel.add(label);
        mainPanel.add(labelLength);
        mainPanel.add(progressBar);
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Password Strength Checker");
        frame.getContentPane().add(new TextLabelMirror().getComponent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}