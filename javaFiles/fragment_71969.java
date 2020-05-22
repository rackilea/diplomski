import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
            JLabel label = new JLabel("Unknown user");
            add(label);

            LoginPanel loginPane = new LoginPanel();
            int result = JOptionPane.showConfirmDialog(this, loginPane, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                label.setText("Welcome " + loginPane.getUsername());
            }

        }

    }

    public class LoginPanel extends JPanel {

        private JTextField userName;
        private JPasswordField password;

        public LoginPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            add(new JLabel("Username: "), gbc);
            gbc.gridy++;
            add(new JLabel("Password: "), gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;

            userName = new JTextField(20);
            password = new JPasswordField(20);

            add(userName, gbc);
            gbc.gridy++;
            add(password, gbc);
        }

        public String getUsername() {
            return userName.getText();
        }

        public char[] getPassword() {
            return password.getPassword();
        }

    }

}