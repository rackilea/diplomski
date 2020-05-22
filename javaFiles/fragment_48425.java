String machaceksName = (String) jdbcTemplate.query(new PreparedStatementCreator() {
  public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
    return connection
        .prepareStatement("select first_name from customer where last_name like ?");
  }
}, new PreparedStatementSetter() {
  public void setValues(PreparedStatement preparedStatement) throws SQLException {
    preparedStatement.setString(1, "Mach%");
  }
}, new ResultSetExtractor() {
  public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    if (resultSet.next()) {
      return resultSet.getLong(1);
    }
    return null;
  }
});