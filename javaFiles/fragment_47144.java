PreparedStatement preparedStatement = dbConnection.prepareStatement(updateSql.toString());
preparedStatement.setString(1, leftRight); // use setString for char types
preparedStatement.setString(2, id);
preparedStatement.seInt(3, number);

preparedStatement .executeUpdate();