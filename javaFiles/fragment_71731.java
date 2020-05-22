private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
     int column = 0;    // get the first column which is ID_Item
     int row = tableItem.getSelectedRow();  //get row selected by user
     int value = (int) tableItem.getModel().getValueAt(row, column); // store ID_Item value
     String answer = new ItemDAO().deleteItem(value);  // call up deleteItem method

     if(answer.equals("OK")) {
         System.out.println("OK"); // just for test
         itemList.clear();    // this is needed to update the bound table after Insert/Delete/Update etc
         itemList.addAll(itemQuery.getResultList()); // same as above comment
     }else{
         System.out.println("ERROR"); // just for test.
     }