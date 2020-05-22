if(jTable1.getSelectedRow() != -1){
   int row = jTable1.getSelectedRow();
   String id = jTable1.getValueAt(row, 0).toString();
   //rest of your code here
}else{
   //show an error for example, no row is selected
}