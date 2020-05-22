// in declarations:
// don't name this jTextField1
private JTextField userNameField = new JTextField();

// public getter method
public String getUserName() {
   return jTextField1.getText(); // this should be named userNameField
}