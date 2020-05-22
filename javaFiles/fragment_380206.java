FieldTitle fieldTitle = FieldTitle.values()[i]; // an enum that holds label texts
JLabel label = new JLabel(fieldTitle.getTitle() + ":", JLabel.LEFT); // create JLabel
JTextField textField = new JTextField(10);  // create JTextField

// set the label's mnemonic -- brings focus to the linked text field
label.setDisplayedMnemonic(fieldTitle.getMnemonic());   

// *** here we *link* the JLabel with the JTextField
label.setLabelFor(textField);