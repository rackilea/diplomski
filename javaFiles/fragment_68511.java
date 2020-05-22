UserModel userObj = new UserModel();

txt_Username.addFocusListener(new FocusAdapter() {
    @Override
    public  void focusLost(FocusEvent arg0) {
 {
     userObj.setUserName(txt_Username.getText());
     //Username= txt_Username.getText();
 }
});