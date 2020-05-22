LoginPanel loginPane = new LoginPanel();
// This will wait here until the dialog is closed for some reason...
int result = JOptionPane.showConfirmDialog(this, loginPane, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
// Then you can determine what you want to do in response to the
// closing of the dialog
if (result == JOptionPane.OK_OPTION) {
    label.setText("Welcome " + loginPane.getUsername());
}