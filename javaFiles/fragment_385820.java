private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {                                          
    boolean rowCompleted;
    int lastRow = jTable1.getRowCount()-1;
    if(jTable1.isRowSelected(lastRow)){
        for(int col=0;col<jTable1.getColumnCount();col++){
            Object value = jTable1.getValueAt(lastRow, col);
            if(value == null || value.toString().trim().isEmpty()){
                rowCompleted=false;
            }
            else{
                rowCompleted=true;
            }
            if(rowCompleted==true){
                model.insertRow(jTable1.getRowCount(), new Object[]{});
            }
            else{
                JOptionPane.showMessageDialog(null, "Something went worng. Try this:\n - Please select a row before adding new row.\n - Please verify there are no empty cells","Processing table's data",1);
            }
            break;
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "Something went wrong. Verify this:\n - There is not any row selected.\n - You can only create new rows after last row","Processing table's data",1);
    }

}