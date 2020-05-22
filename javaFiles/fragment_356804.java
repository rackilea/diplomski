public static void writeToDb(String name, String no, String no1) {

 //connect to database
    String insertTableSQL = "INSERT INTO DBUSER"
            + "(USERNAME, no, no1) VALUES" + "(?,?,?)";
    PreparedStatement preparedStatement = dbConnection
            .prepareStatement(insertTableSQL);
    preparedStatement.setString(1, name);
    preparedStatement.setString(2, no);
    preparedStatement.setString(3, no1);
    preparedStatement.executeUpdate();

}

   }