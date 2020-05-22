import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout101 {

    public static void main(String[] args) {
        new TestLayout101();
    }

    public TestLayout101() {
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

        private JTextField fullNameTextField = new JTextField(10);
        private JTextField emailIDTextField = new JTextField(10);
        private JTextArea addressTextArea = new JTextArea(10, 20);
        private JButton submitButton = new JButton("Submit");
        private JButton cancelButton = new JButton("Cancel");

        public TestPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(new JLabel("Full Name: "), gbc);
            gbc.gridy++;
            add(new JLabel("Email ID: "), gbc);
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            add(new JLabel("Address: "), gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;

            add(fullNameTextField, gbc);
            gbc.gridy++;
            add(emailIDTextField, gbc);
            gbc.gridy++;
            gbc.weighty = 1;
            add(new JScrollPane(addressTextArea), gbc);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 4, 4));
            buttons.add(submitButton);
            buttons.add(cancelButton);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weighty = 0;
            add(buttons, gbc);
        }
    }
}