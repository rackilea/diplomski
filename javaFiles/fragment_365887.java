private void goSettingsActionPerformed(java.awt.event.ActionEvent evt) {                                           
    Settings settings = new Settings();
    int result = JOptionPane.showOptionDialog(null,
            settings,
            "Settings",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Save", "Cancel"},
            "default");
    if (result == JOptionPane.OK_OPTION) {

        // **** give your Settings class this method:
        username = settings.getUserName(); 
        usernameInputedLabel.setText(username);
    }
}