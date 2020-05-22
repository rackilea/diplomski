final JTextField userNameField = new JTextField(10);
final JPasswordField passwordField = new JPasswordField(10);
JPanel pane = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, 
        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 
        new Insets(2, 2, 2, 2), 0, 0);
pane.add(new JLabel("User Name:"), gbc);

gbc.gridy = 1;
pane.add(new JLabel("Password:"), gbc);

gbc.gridx = 1;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.EAST;
pane.add(userNameField, gbc);

gbc.gridy = 1;
pane.add(passwordField, gbc);

int reply = JOptionPane.showConfirmDialog(null, pane, "Please Log-In", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
if (reply == JOptionPane.OK_OPTION) {
    // get user input
    String userName = userNameField.getText();

    // ****** WARNING ******
    // ** The line below is unsafe code and makes a password potentially discoverable
    String password = new String(passwordField.getPassword());

    System.out.println("user name: " + userName);
    System.out.println("passowrd:  " + password);
}