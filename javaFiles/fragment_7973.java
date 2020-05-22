public void checkEmpty() {
    JTextField [] textFields = {jTextField1,jTextField2,jTextField3,jTextField4,jTextField5,jTextField6};
    isInputValid = true;
    for (int i = 0; i < textFields.length; i++) {
        JTextField jTextField = textFields[i];
        String textValue = jTextField.getText().trim();
        if (textValue.length() == 0) {
            //turn background into red
            jTextField.setBackground(Color.RED);
            isInputValid = false;
        }
    }

    // now check if input are valid
    if(!isInputValid) return;

    //save to database----> I know what I have to do here.
}