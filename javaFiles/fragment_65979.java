public void incBalance(int accountId, int val) {
  Connection conn = daoFactory.getConnection();
  incBalance(conn, accountId, val);
}

private void incBalance(Connection conn, int accountId, int val) {
  con.update(...);
}

public void transfer(...) {
  Connection conn = daoFactory.getConnection();
  conn.beginTransaction();
  ...
  incBalance(conn, acc1, val);
  incBalance(conn, acc2, -val);
  ...
  conn.commit();
}