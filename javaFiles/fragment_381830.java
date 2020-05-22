if(evt.getKeyCode() == KeyEvent.VK_ENTER){

    int RowInView = YourTableName.getSelectedRow();

    if(RowInView >= 0){
    int RowInTableModel = YourTableName.convertRowIndexToModel(RowInView);

    String TextOnColumn1 = (YourTableName.getModel().getValueAt(RowInTableModel, 0).toString());
    String TextOnColumn2 = (YourTableName.getModel().getValueAt(RowInTableModel, 1).toString());
    String TextOnColumn3 = (YourTableName.getModel().getValueAt(RowInTableModel, 2).toString());

   // Write the code to update the employees details using these string values.
    }
}