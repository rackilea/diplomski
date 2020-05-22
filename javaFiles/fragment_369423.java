public static class SQL {

Connection connection = null;
String connectionUrl = "jdbc:mysql://localhost:3306/bank";
String connectionUser = "admin";
String connectionPassword = "root";


public SQL(){}

public Connection getConnection () {

  if (connection != null) {
    return connection;
  }
  try{

  Class.forName("com.mysql.jdbc.Driver").newInstance();
  connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
  return connection; 
 }
  catch(Exception e){
    e.printStackTrace();
}
　return null;　　　
　}
  }