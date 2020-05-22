import java.sql.*;
import javax.sql.*;

public class MysqlPathFinderDemo{

public static void main(String args[]){
String dbtime;
String dbUrl = "jdbc:mysql://your.database.domain/yourDBname";
String dbClass = "com.mysql.jdbc.Driver";
String query = "Select * FROM users";

try {

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection (dbUrl);
      Statement stmt = con.createStatement();
      res = Myconnection.st.executeQuery("select @@datadir");
      String Mysqlpath = "";

      while(res.next()){
          Mysqlpath=res.getString(1) ;
      }

      Mysqlpath = Mysqlpath.replace("Data", "bin"); 
      System.err.println("Mysql path is :"+a);
   } catch(Exception ee) {
   }
 }
}