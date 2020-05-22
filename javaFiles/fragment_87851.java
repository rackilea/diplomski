public class UserRoleAwareSpringManagedTransactionFactory implements TransactionFactory {
  @Override
  public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
    return new UserRoleAwareSpringManagedTransaction(dataSource);
  }
  @Override
  public Transaction newTransaction(Connection conn) {
    throw new UnsupportedOperationException("New Spring transactions require a DataSource");
  }
  @Override
  public void setProperties(Properties props) {
  }
}