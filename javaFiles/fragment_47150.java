private void fontboxActionPerformed(java.awt.event.ActionEvent evt) {
    String font = (String) fontbox.getSelectedItem();

    if(font=="Bold")
        textField.setFont(new Font("Calibri", Font.BOLD, 18));
    else if(font == "Italic")
        textField.setFont(new Font("Calibri", Font.ITALIC, 18));
    else if(font == "Plain")
        textField.setFont(new Font("Calibri", Font.PLAIN, 18));

}