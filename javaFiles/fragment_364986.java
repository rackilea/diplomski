import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestLayout100 {

    public static void main(String[] args) {
        new TestLayout100();
    }

    public TestLayout100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new LoginPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LoginPanel extends JPanel {

        private JTextField userfield;
        private JPasswordField passfield;

        private JButton login;
        private JButton create;

        public LoginPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JPanel fields = new JPanel(new GridBagLayout());

            gbc.anchor = GridBagConstraints.EAST;
            JLabel label = new JLabel("Username: ");
            gbc.gridx = 1;
            fields.add(label, gbc);

            label = new JLabel("Password: ");
            gbc.gridy = 1;
            fields.add(label, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            userfield = new JTextField(10);
            gbc.gridx = 2;
            gbc.gridy = 0;
            fields.add(userfield, gbc);

            passfield = new JPasswordField(10);
            gbc.gridy = 1;
            fields.add(passfield, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.CENTER;
            login = new JButton("Login");
            gbc.gridwidth = 2;
            gbc.gridx = 1;
            gbc.gridy = 2;
            fields.add(login, gbc);

            create = new JButton("Create Account");
            gbc.gridy = 3;
            fields.add(create, gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(fields, gbc);

            JTextPane textpane = new JTextPane();
            gbc.weightx = 1;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(textpane, gbc);
        }
    }

}