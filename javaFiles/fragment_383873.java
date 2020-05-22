JPasswordField password = new JPasswordField(10);
JLabel label = new JLabel("Password: ");
JPanel panel = new JPanel();
panel.add(label);
panel.add(password);

int option = JOptionPane.showConfirmDialog(null, panel, "Password", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
    char[] userPassword = password.getPassword();
    byte[] bytes = new byte[userPassword.length * 2];
    for (int i = 0; i < userPassword.length; i++) {
        bytes[i * 2] = (byte) (userPassword[i] >> 8);
        bytes[i * 2 + 1] = (byte) userPassword[i];
    }
    os.write(bytes);
}