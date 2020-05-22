public class BaseDAO {

 public Connection getConnection() {
   Class.forName("com.mysql.jdbc.Driver");
   String url = "jdbc:mysql://localhost:3306/saloon";
   String name = "root";
   String password = "";

   Connection con = DriverManager.getConnection(url, name, password);
   return con;
 }
}