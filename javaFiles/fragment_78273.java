public NewUserFrame_Edit(AllUser userModel/*Add this parameter*/,UserInformation userinf, int row) {
...
    this.userModel = userModel;
    jTextField1.setText(userinf.getFname().toString().trim());
    jTextField2.setText(userinf.getLname().toString().trim());

    if (userinf.getGender().equals("Male")) {
        jRadioButton1.setSelected(true);
    } else {
        jRadioButton2.setSelected(true);
    }

    jTextField3.setText(userinf.getDate());
    selectedrow = row;
    setVisible(true);
}