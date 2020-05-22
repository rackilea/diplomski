public void actionPerformed(ActionEvent e) {

    if (! textFieldsValid()) {
        // one or more of the text fields are empty
        // may be display a message in a JOptionPane
        System.out.println("The text fields are not filled with data, etc...");
        return;
    }

    // else, text fields have valid data, so do whatever processing it further...
}

/*
 * This method checks if the text fields are empty and sets their borders as red. Returns
 * a boolean false in case any of the text fields are empty, else true.
 */
private boolean textFieldsValid() {

    boolean validTextFields = true;

    if (textField1.getText().isEmpty()) {
        validTextFields = false;
        textField1.setBorder(new LineBorder(Color.RED));
    }

    if (textField2.getText().isEmpty()) {
        validTextFields = false;
        // textField2.setBorder(...)
    }

    // ... same with textField3 and textField4

    return validTextFields;
}