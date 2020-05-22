private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {                                           
    String userInput = txtField1.getText(); //userInput equals to whatever the user typed in txtField1

    // check this out *** here ***
    if(comboBoxFrom.getSelectedItem().equals(comboBoxTo.getSelectedItem())){
        JOptionPane.showMessageDialog(null, "Cannot convert to the same unit type.", 
                "Um, You Forgot Something!!", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    try{
        Double.parseDouble(userInput); //checks to see if the userInput from the txtField1 is an integer if not the catch takes control

        for(String s: UNIT_NAME){
            if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Centimeters")){