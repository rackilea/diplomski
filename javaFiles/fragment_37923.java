Label label = new Label(parent, SWT.NONE);
label.setText("Please Enter Pincode:");
label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

Text txtPincode = new Text(parent, SWT.NONE);
txtPincode.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

//Adding the decorator
final ControlDecoration txtDecorator = new ControlDecoration(txtPincode, SWT.TOP|SWT.RIGHT);
FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry .DEC_ERROR);
Image img = fieldDecoration.getImage();
txtDecorator.setImage(img);
txtDecorator.setDescriptionText("Pls enter only numeric fields");
// hiding it initially
txtDecorator.hide();

txtPincode.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        Text text = (Text)e.getSource();            
        String string = text.getText();
        char[] chars = new char[string.length()];
        string.getChars(0, chars.length, chars, 0);
        for (int i = 0; i < chars.length; i++) {
            if (!('0' <= chars[i] && chars[i] <= '9')) {
                txtDecorator.show();
            } else {
                txtDecorator.hide();
            }
        }      
    }
});