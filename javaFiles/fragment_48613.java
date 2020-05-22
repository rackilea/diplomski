String sql = "UPDATE table SET col1 = ? WHERE some_col = ?";
// ...    
preparedStatement = connection.prepareStatment(sql);
preparedStatement.setString(1, col1);
preparedStatement.setString(2, someCol);
int affectedRows = preparedStatement.executeUpdate();
// ...