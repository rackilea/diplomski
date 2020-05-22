invalid_login_label.setVisible(false);
username_label.setVisible(false);
user_field.setVisible(false);
password_label.setVisible(false);
pass_field.setVisible(false);

access_granted_label.setVisible(true);
javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
    public void actionListener(ActionEvent evt) {
        dispose();
    }
});
timer.setRepeats(false);
timer.start();