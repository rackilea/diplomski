try {
   //must be upper case
   String username="dbuser1".toUpperCase();

   ResultSet row = dbmd.getTables("%", username , "%", types);

    while (row.next()) {
      //you need table name for trigger name
      result.getString("TABLE_NAME");
    }
  //catch some errors
  } catch (SQLException e) {
      while (e != null) {
        System.out.println("\n Message: " + e.getMessage());
        System.out.println("\n SQLState: " + e.getSQLState());
        System.out.println("\n ErrorCode: " + e.getErrorCode());
        e = e.getNextException();
      }
   }