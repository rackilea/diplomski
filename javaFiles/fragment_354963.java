private void btnJFrame1ActionPerformed(java.awt.event.ActionEvent evt) 
{
    JFrame2 jf2 = new JFrame2(
                              Get_Fields(txtField1.getText()),
                              Get_Fields(txtField2.getText()),
                              Get_Fields(txtField3.getText()),
                              Get_Fields_Asterisk(txtField1.getText()),
                              Get_Fields_Asterisk(txtField1.getText()),
                              Get_Fields_Asterisk(txtField1.getText()));
    jf2.setVisible(true);
}