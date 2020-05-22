for (int i = 0; i < model.getRowCount(); i++) { 
   if (!model.getValueAt(i, 0).equals("Windows")){

   model.removeRow(i);
   i-=1;  // 
  }