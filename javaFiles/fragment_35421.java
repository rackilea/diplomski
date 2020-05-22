// Connection connection = <your java.sql.Connection>
ResultSet resultSet = connection.getMetaData().getCatalogs();

//iterate each catalog in the ResultSet
while (resultSet.next()) {
  // Get the database name, which is at position 1
  String databaseName = resultSet.getString(1);
}
resultSet.close();