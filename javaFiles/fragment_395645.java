public class LoginPane extends JPanel implements LoginView {

    private JTextField userName;
    private JPasswordField password;
    private JButton okButton;
    private JButton cancelButton;
    private LoginController controller;

    public LoginPane() {
        setLayout(new GridBagLayout());
        userName = new JTextField(10);
        password = new JPasswordField(10);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.WEST;

        add(new JLabel("User name: "), gbc);
        gbc.gridy++;
        add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(userName, gbc);
        gbc.gridy++;
        add(password, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(okButton, gbc);
        gbc.gridx++;
        add(cancelButton, gbc);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().performLogin(LoginPane.this);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().loginCanceled(LoginPane.this);
            }
        });
    }

    @Override
    public String getUserName() {
        return userName.getText();
    }

    @Override
    public char[] getPassword() {
        return password.getPassword();
    }

    @Override
    public void loginFailed(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "Login failed", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void setController(LoginController controller) {
        this.controller = controller;
    }

    @Override
    public JComponent getView() {
        return this;
    }

    @Override
    public LoginController getController() {
        return controller;
    }

}