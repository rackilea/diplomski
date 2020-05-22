public void actionPerformed(ActionEvent e) {
    boolean sel = _useSSL.isSelected();
    _port.setUseSSL(sel);
    _keystore.setEnabled(sel);
    _passphrase.setEnabled(sel);
    L_KEYSTORE.setEnabled(sel);
    L_PASSPHRASE.setEnabled(sel);
    boolean trus = _truststore.isSelected();
    //Use trus for the other things
}