Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
DatabaseMetaData metadata = connection.getMetaData();
ResultSet resultSet;
resultSet = metadata.getTables(null, null, "tablename", null);
if(resultSet.next())
    // Table exists

resultSet = metadata.getColumns(null, null, "tablename", "columnName");
if(resultSet.next())
    // Column exists