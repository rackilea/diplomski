import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestCardLayout100 {

    public static void main(String[] args) {
        new TestCardLayout100();
    }

    public TestCardLayout100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                LoginPane loginPane = new LoginPane();
                RegisterPane registerPane = new RegisterPane();

                JPanel startPane = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                startPane.add(loginPane, gbc);
                gbc.gridx = 2;
                startPane.add(registerPane, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.VERTICAL;
                startPane.add(new JSeparator(JSeparator.VERTICAL), gbc);

                JPanel loggedInPane = new JPanel(new GridBagLayout());
                loggedInPane.add(new JLabel("Logged In..."));

                JPanel registeredPane = new JPanel(new GridBagLayout());
                registeredPane.add(new JLabel("Registered..."));

                final JFrame frame = new JFrame("Testing");
                final CardLayout cardLayout = new CardLayout();

                loginPane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(frame.getContentPane(), "loggedIn");
                    }
                });
                registerPane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(frame.getContentPane(), "registered");
                    }
                });

                Container contentPane = frame.getContentPane();
                contentPane.setLayout(cardLayout);
                contentPane.add(startPane, "startPane");
                contentPane.add(loggedInPane, "loggedIn");
                contentPane.add(registeredPane, "registered");

                cardLayout.show(contentPane, "startPane");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LoginPane extends JPanel {

        private final JLabel logusrlbl = new JLabel("Enter Username");
        private final JLabel logpwdlbl = new JLabel("Enter Password");
        private final JTextField logusr = new JTextField(10);
        private final JTextField logpwd = new JPasswordField(10);
        private final JButton login = new JButton("Login");

        public LoginPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JLabel("Login"), gbc);

            gbc.gridy++;
            gbc.gridwidth = 1;
            add(logusrlbl, gbc);
            gbc.gridy++;
            add(logpwdlbl, gbc);

            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridy = 1;

            add(logusr, gbc);
            gbc.gridy++;
            add(logpwd, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.NONE;
            add(login, gbc);

        }

        public void addActionListener(ActionListener listener) {
            login.addActionListener(listener);
        }

    }

    public class RegisterPane extends JPanel {

        private final JLabel logusrlbl = new JLabel("Enter Username");
        private final JLabel logpwdlbl = new JLabel("Enter Password");
        private final JTextField logusr = new JTextField(10);
        private final JTextField logpwd = new JPasswordField(10);
        private final JButton register = new JButton("Register");

        public RegisterPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JLabel("Register"), gbc);

            gbc.gridy++;
            gbc.gridwidth = 1;
            add(logusrlbl, gbc);
            gbc.gridy++;
            add(logpwdlbl, gbc);

            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridy = 1;

            add(logusr, gbc);
            gbc.gridy++;
            add(logpwd, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(register, gbc);

        }

        public void addActionListener(ActionListener listener) {
            register.addActionListener(listener);
        }

    }

}