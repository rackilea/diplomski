private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int viewIndex = jTable1.getSelectedRow();
    if(viewIndex != -1) {
        int modelIndex = jTable1.convertRowIndexToModel(viewIndex); // converts the row index in the view to the appropriate index in the model
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow(modelIndex);
    }
}