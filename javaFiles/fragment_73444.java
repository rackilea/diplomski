private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
    //suppose this is your file input, that you will have to read
    String[] test = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    //your combobox name supposed it is combo
    //remove all the previous items
    combo.removeAllItems();
    //add all the items of the array(there is no addAll method)
    for(int i=0; i<test.length; i++)
        combo.addItem(test[i]);
}