try {
     connection = dataSource.getConnection();

     statement = connection.createStatement();
     ResultSet rs1=statement.execute("....");

     //parse rs1
     //close rs1

     ResultSet rs2= statement.execute(....);
     //parse rs1
     //close rs1

  } finally {
    Utils.tryClose(statement);
    Utils.tryClose(connection);
  }