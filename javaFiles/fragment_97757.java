Connection dbConnection=null;
PreparedStatement preparedStatement=null;
ResultSet rs = null;
try {
  dbConnection = getConnection();
  preparedStatement = dbConnection.preparedStatement(...);

  ... bind variables to preparedStatement ...

  rs = preparedStatement.executeQuery();

  ... work with result set ...

} finally {
  if (rs!=null)
    rs.close();
  if (preparedStatement!=null)
    preparedStatement.close();
  if (dbConnection!=null)
    dbConnection.close();
}