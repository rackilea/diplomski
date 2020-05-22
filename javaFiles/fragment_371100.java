private void bAdd11ActionPerformed(java.awt.event.ActionEvent evt) {                                       
    ErrorMessage.setText("");
    DefaultTableModel model3;
    model3 = (DefaultTableModel) tblProduct11.getModel();
    if(!tfChassi.getText().trim().equals("")){
        model3.addRow(new Object[]{
            tf1.getText(),
            tf2.getText(),
            tf3.getText(),
            cb1.getSelectedItem().toString(),
            cb2.getSelectedItem().toString(),
            cb3.getSelectedItem().toString(),
            cb4.getSelectedItem().toString(),
            tf4.getText(),
            tf5.getText(),
            bgButtonGroup.getSelection().getActionCommand()
        }
    );