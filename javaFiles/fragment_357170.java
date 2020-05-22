button.addActionListener(new ActionListener() { 
    actionPerformed(ActionEvent eText) {
    //Get info from dialog
    yShift = textField_Y.getText();
    xShift = textField_X.getText();
    nPos = Integer.parseInt(textField_n.getText());
    print(xshift+" "+yshift+" "+nPos);
});