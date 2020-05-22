private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    Calender frmMain = new Calender();
    calender.setIUpdateText(this);  // assuming 'this' is an IUpdateText interface compliant
    frmMain.pack();
    frmMain.setVisible(true);
}