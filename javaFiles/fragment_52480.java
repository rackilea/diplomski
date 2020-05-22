public boolean execute(String sql) throws SQLException{
     Statement statement = null;
    try {
        statement = connection.createStatement();
        return statement.execute(sql);
    }finaly{
         if (statement != null) statement.close();
     }

UPDATE