private void buttonAddGroceryItemActionPerformed(java.awt.event.ActionEvent evt) {
    String groceryItem = jTextField1GroceryItem.getText();
    String quantity = jTextField2Quantity.getText();
    String unit = jComboBox1Unit.getSelectedItem().toString();
    jTextArea1.append(groceryItem + " " + quantity + " " + unit + "\n" );
}

private void buttonRemoveGroceryItemActionPerformed(java.awt.event.ActionEvent evt){
    String choice = jTextArea1.getSelectedText();
    try {
        jTextArea1.setText(jTextArea1.getText().replaceAll(choice, ""));
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(this, "Please select a valid item from the grocery list before clicking to remove.",
                "Invalid Item selected for removal", JOptionPane.ERROR_MESSAGE);
    }
}