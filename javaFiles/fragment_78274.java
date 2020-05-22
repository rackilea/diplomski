private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    //userModel = new AllUser();//Comment it.
    userinf = new UserInformation();

    userinf.setFname(jTextField1.getText());
    userinf.setLname(jTextField2.getText());
    userinf.setGender(gender);
    userinf.setDate(jTextField3.getText());

    userModel.setValueAt(userinf.getFname() , selectedrow, 1);
    userModel.setValueAt(userinf.getLname() , selectedrow, 2);
    userModel.setValueAt(userinf.getGender(), selectedrow , 3);
    userModel.setValueAt(userinf.getDate() , selectedrow, 4);
    userModel.updateFile(userModel.Udata);

    NewUserFrame_Edit.this.dispose();
}