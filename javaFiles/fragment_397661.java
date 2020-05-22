private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {                                      

    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        populateRoundNMS();
    }
}                                     

private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           

    if (evt.getModifiers() != 0) {
        populateRoundNMS();
    }
}  

private void populateRoundNMS(){
    //Run SQL and Populate jComboBox2
}