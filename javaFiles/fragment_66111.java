val = 0;
String message = "Invalid";
if(checkCredentials(user, pass)) {
    message = "Login";
    val = 1;
    vf.setVisible(true);
}
JOptionPane.showMessageDialog(null, message);