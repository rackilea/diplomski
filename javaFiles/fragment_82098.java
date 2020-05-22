private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rs = null;
  ..... .......
  connect();
  stmt = conn.createStatement();

  rs = stmt.executeQuery("SELECT name FROM users");

  while(rs.next()){
    String name = rs.getString(1);
    System.out.println("User: "+name);
  }