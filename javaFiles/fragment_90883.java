conn.setAutoCommit(false);
try {
  ...
  ps.executeBatch();
  conn.commit();
} catch (Exception e) {
  conn.rollback();
}