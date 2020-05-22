import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MenuLogin extends JPanel {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public MenuLogin() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel form = new JPanel(); // The panel that won't show
        form.setVisible(true);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 36));
        form.add(lblLogin);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        txtUsername.setToolTipText("Username");
        txtUsername.setColumns(16);
        form.add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        txtPassword.setToolTipText("Password");
        txtPassword.setColumns(16);
        form.add(txtPassword);

        JButton btnProceed = new JButton("Proceed");
        btnProceed.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        form.add(btnProceed);

        JButton btnPlayAsGuest = new JButton("Play As Guest");
        btnPlayAsGuest.setFont(new Font("Trebuchet MS", Font.PLAIN, 9));
        form.add(btnPlayAsGuest);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        form.add(btnSignUp);

        add(form, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.add(new MenuLogin());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}