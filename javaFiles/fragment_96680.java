public class LogIn extends JFrame {

    private String userName;
    private String password;
    private String DBAddress;

    private JTextField textFieldName;
    private JTextField textFieldPassword;
    private JLabel lblUsername;
    private JLabel lblPassword;

    public LogIn() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setAlwaysOnTop(true);
        setBounds(100, 100, 343, 295);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        textFieldName = new JTextField();
        textFieldName.setBounds(93, 60, 148, 20);
        getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(93, 115, 148, 20);
        textFieldPassword.setColumns(10);
        getContentPane().add(textFieldPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {

            // po nacisnieciu klawisza biore w variables umieszczam stringi
            // pobrane z tych pól
            public void actionPerformed(ActionEvent arg0) {

                String userName = textFieldName.getText();
                String password = textFieldPassword.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception ex) {
                    // handle the error
                }
                Connection con = new Connection();

                if (con.register() && con.connect(userName, password)) {
                    Base bas = new Base();
                    bas.setVisible(true);
                    dispose();
                }

            }
        });
        btnLogin.setBounds(107, 146, 121, 23);
        getContentPane().add(btnLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(132, 35, 71, 14);
        getContentPane().add(lblUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(132, 91, 71, 14);
        getContentPane().add(lblPassword);
    }

}