public class Test extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField tfUsername;
    private JPasswordField tfPwd;

    public Test() {
        super();
        JPanel myPanel = new JPanel();
        getContentPane().add(myPanel);
        myPanel.add(new JLabel("Username: "));
        tfUsername = new JTextField(10);
        myPanel.add(tfUsername);
        myPanel.add(Box.createHorizontalStrut(20)); // a horizontal spacer
        myPanel.add(new JLabel("Password: "));
        tfPwd = new JPasswordField(10);
        myPanel.add(tfPwd);
        JButton btnLogin = new JButton("Login");
        myPanel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String user = tfUsername.getText();
                if (usernamefield(user)) {
                    String pwd = tfPwd.getText(); // Deprecated (use "getPassword()" for better security, see https://stackoverflow.com/q/8881291/1098603)
                    if (pwdfield(pwd))
                        JOptionPane.showMessageDialog(Test.this, "Password verified.");
                    else
                        JOptionPane.showMessageDialog(Test.this, "Error: Wrong username/password.", "Login error", JOptionPane.ERROR_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(Test.this, "Error: Unknown username.", "Login error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        // You can do that outside of EDT (see https://stackoverflow.com/q/491323/1098603)
        Test frm = new Test();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Outside of Test class so close operation is defined by the user and not the class
        frm.pack();
        frm.setVisible(true);
    }

    private static boolean usernamefield(String user) {
        return "user".equals(user);
    }

    private static boolean pwdfield(String password) { // TODO: Change String to char[] to improve security
        return "pwd".equals(password);
    }
}