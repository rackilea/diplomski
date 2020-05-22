...
con.setAutoCommit(false);
try {
  while (rs.next()) {
    if (conditions_to_update) {
      rs.updateString(...);
      rs.updateRow();
    }
  }
  con.setAutoCommit(true);
} catch (Exception ex) {
  //log the exception and rollback
  con.rollback();
} finally {
  con.close();
}