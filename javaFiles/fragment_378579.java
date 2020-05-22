private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // check the values of the text fields including an or condition for regular expressions
    if (jTextField1.isEmpty() || jTextField1.getText().matches("\\d+.?\\d*") {
        // you can use something like a modal to alert
        JOptionPane.showMessage(null,"Must enter a decimal value");
    } else {
        // do something with jTextField1
    }
}