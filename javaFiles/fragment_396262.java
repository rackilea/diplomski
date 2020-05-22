class MyConnectionProvider implements ConnectionProvider {
    @Override
    public Connection acquire() {
         return ServiceConnectionManager.getConnection();
    }

    @Override
    public void release(Connection connection) {
         try {
             connection.close();
         }
         catch (SQLException e) {
             throw new DataAccessException("Error while closing", e);
         }
    }
}