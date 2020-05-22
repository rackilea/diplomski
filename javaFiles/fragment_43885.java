public void setValueAt(Object value, int row, int column) {
  try {
 //get the value  and update cacheRowSet
  this.coffeesRowSet.absolute( row + 1 );
  this.coffeesRowSet.updateObject((column + 1), value);
  this.coffeesRowSet.updateRow();
  this.coffeesRowSet.setTableName("TICKETLINES");

  this.coffeesRowSet.acceptChanges(s.getConnection());
  this.coffeesRowSet.refreshRow();
  } catch (SQLException ex) {
  Logger.getLogger(CoffeesTableModel.class.getName()).log(Level.SEVERE, null, ex);
  }
  fireTableCellUpdated(row, column);
  }