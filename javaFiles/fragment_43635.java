public Connection dbConnect(String dbconnectionstring,String userid,String userpassword)
{
    Connection connection = null;
    System.out.println();
  try {
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
     connection = DriverManager.getConnection(dbconnectionstring,userid,userpassword);
     System.out.println("connected to" + dbconnectionstring );

    } catch (InstantiationException | IllegalAccessException  | ClassNotFoundException  | SQLException e) {
        throw new IllegalStateException("Connection failure", e);
    }

  return connection;
}