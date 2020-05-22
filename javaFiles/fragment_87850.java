import org.springframework.security.core.Authentication;

class UserRoleAwareSpringManagedTransaction extends SpringManagedTransaction {

  public UserRoleAwareSpringManagedTransaction(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public Connection getConnection() throws SQLException {
    Connection connection = getCurrentConnection();
    setUserRole(connection);
    return connection;
  }

  private Connection getCurrentConnection() {
    return super.getConnection();
  }

  @Override
  public void close() throws SQLException {
    resetUserRole(getCurrentConnection());
    super.close();
  }  

  private void setUserRole(Connection connection) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    Statement statement = connection.createStatement();
    try {
      // note that this direct usage of usernmae is a subject for SQL injection
      // so you need to use the suggestion from
      // https://stackoverflow.com/questions/2998597/switch-role-after-connecting-to-database
      // about encoding of the username
      statement.execute("set role '" + username + "'");
    } finally {
      statement.close();
    }
  }

  private void resetUserRole(Connection connection) {
    Statement statement = connection.createStatement();
    try {
      statement.execute("reset role");
    } finally {
      statement.close();
    }
  }

}