private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {         
    JOptionPane.showMessageDialog(null, "Completed Analysis!","Alert", 1);
    jButton5.setEnabled(false);
    jTextArea2.setEditable(false);
    jTextArea3.setEditable(false);
    ClassName.main(new String[]{"arg1","arg2"}); 
}