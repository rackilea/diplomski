String insertTableSQL = "INSERT INTO DBUSER"
    + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
    + "(?,?,?,?)";
PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
preparedStatement.setInt(1, 11);
preparedStatement.setString(2, "username");
preparedStatement.setString(3, "password");
preparedStatement.setTimestamp(4, getCurrentTimeStamp());
// execute insert SQL statement
preparedStatement .executeUpdate();