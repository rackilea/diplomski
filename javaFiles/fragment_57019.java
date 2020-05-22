import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
    private static final int GAP = 3;
    private JTextField usernameField = new JTextField(10);
    private JPasswordField passwordField = new JPasswordField(10);

    public LoginPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = getGbc(0, 0);
        add(new JLabel("User Name:"), gbc);
        gbc = getGbc(1, 0);
        add(usernameField, gbc);
        gbc = getGbc(0, 1);
        add(new JLabel("Password:"), gbc);
        gbc = getGbc(1, 1);
        add(passwordField, gbc);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
    }

    private static GridBagConstraints getGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(GAP, GAP, GAP, GAP);
        gbc.anchor = x == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;        

        return gbc;
    }

    public String getUserName() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }
}