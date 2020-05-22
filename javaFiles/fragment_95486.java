final Object queryResultObject = session.doReturningWork(new ReturningWork<ReturnObjectType>() {

  @Override
  public ReturnObjectType execute(Connection connection) throws SQLException {

    final Statement statement = connection.createStatement();
    statement.execute("set @rank = 0");

    final ResultSet resultSet = statement.executeQuery(
                                      "select @rank := @rank + 1 as rank,id,name
                                       from test");

    ReturnObjectType result = /* transform ResultSet into return value */

    return result;
  }
});