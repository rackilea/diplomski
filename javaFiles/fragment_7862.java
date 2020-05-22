package swingbeginner;

public class LoginForm {

    private JFrame mainFrame;

    private JLabel headerLabel;

    private JLabel inputLabel;

    private JPanel inputPanel;

    private JPanel controlPanel;

    private JLabel statusLabel;

    public LoginForm() {
        prepareGUI();
    }

    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm();
        loginForm.loginProcess();
    }

    private void prepareGUI() {

        mainFrame = new JFrame("Login");
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(new BorderLayout());

        headerLabel = new JLabel("header", JLabel.CENTER);
        statusLabel = new JLabel("status", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowEvent) {

            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

        mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(controlPanel, BorderLayout.CENTER);
        mainFrame.add(statusLabel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private void loginProcess() {

        headerLabel.setText("Please Login to Continue!");

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 20, 80, 25);

        JTextField usernameTextbox = new JTextField(20);
        usernameTextbox.setBounds(100, 20, 165, 25);
        JPasswordField passwordTextbox = new JPasswordField(20);
        passwordTextbox.setBounds(100, 20, 165, 25);

        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        loginButton.setActionCommand("Login");
        cancelButton.setActionCommand("Cancel");

        loginButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(usernameLabel);
        controlPanel.add(usernameTextbox);
        controlPanel.add(passwordLabel);
        controlPanel.add(passwordTextbox);
        controlPanel.add(loginButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {

            String command = actionEvent.getActionCommand();
            if (command.equals("Login")) {
                statusLabel.setText("Logging In");
            }
            else if (command.equals("Cancel")) {
                statusLabel.setText("Login Cancelled");
            }
        }
    }
}