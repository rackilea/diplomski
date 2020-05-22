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

public class MakeItSo {

    public static void main(String[] args) {
        new MakeItSo();
    }

    public MakeItSo() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(new JLabel("Choose this:"), gbc);
            gbc.gridx++;
            add(new JLabel("Or this:"), gbc);

            JTextField thisOne = new JTextField(10);
            JTextField orThisOne = new JTextField(10);

            thisOne.getDocument().addDocumentListener(new ManagedDocumentHandler(thisOne, orThisOne));
            orThisOne.getDocument().addDocumentListener(new ManagedDocumentHandler(orThisOne, thisOne));

            gbc.gridx = 0;
            gbc.gridy++;

            add(thisOne, gbc);
            gbc.gridx++;
            add(orThisOne, gbc);
        }

        public class ManagedDocumentHandler implements DocumentListener {

            private JTextField toBe;
            private JTextField orNotToBe;

            public ManagedDocumentHandler(JTextField toBe, JTextField orNotToBe) {
                this.toBe = toBe;
                this.orNotToBe = orNotToBe;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateState();
            }

            protected void updateState() {
                toBe.setEnabled(true);
                orNotToBe.setEnabled(toBe.getText().trim().length() == 0);
            }

        }

    }

}