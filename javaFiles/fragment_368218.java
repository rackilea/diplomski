public void actionPerformed(ActionEvent e)
  .
  .
  .
    try {
        byte[] encrypted = encrypt(concatURL);
        String encryptedString = bytesToHex(encrypted);
        content.removeAll();
        content.add(new JLabel("Concatenated User Input -->" + concatURL));

        content.add(encryptedTextField);
    setContentPane(content);
    } catch (Exception exc) {
        // TODO: handle exception
    }
}