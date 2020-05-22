import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TestInput {

    public static void main(String[] args) {
        new TestInput();
    }

    public TestInput() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new InputPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class InputPane extends JPanel {

        private JTextField textField;
        private JLabel label;

        public InputPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            textField = new JTextField(20);
            label = new JLabel(" ");

            add(textField, gbc);
            add(label, gbc);

            textField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateLabel();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateLabel();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateLabel();
                }

                protected void updateLabel() {
                    label.setText(textField.getText());
                }
            });
        }

    }

}