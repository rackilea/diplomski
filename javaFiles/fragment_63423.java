public void stateChanged(ChangeEvent e) {
   final int quantity = (int) ((JSpinner) e.getSource()).getValue();
   final int rows = table.getRowCount();
   for (int row = 0; row < rows; ++row) {
      // look for the row that has the JSpinner in its last column
      if (dtm.getValueAt(row, 3) == e.getSource()) {
         // log out something
         System.out.println("Modifying row " + row);
         // modifying the value in the model
         dtm.setValueAt(quantity, row, 1); // obj, row, column
         return;
      }
   }
   // there was no row with this JSpinner, so we have to add it
   for (int i = 0; i < ELEMENTS; i++) {
      // looking for the "clicked" JSpinner
      if (numspinner[i] == e.getSource()) {
         // log out something
         System.out.println("Adding row " + rows);
         // adding a new row to the model
         dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, price[i] * quantity, numspinner[i] });
         return;
      }
   }   
}