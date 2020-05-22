public void clearFlds(List<JTextField> textFields, String toBeReplace){
    for (JTextField jflds: textFields){
        jflds.setText(toBeReplace);
    }
}


private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
    clearFlds(Arrays.asList(txtfname,txtmname,txtlname,txtaddress),"");
}