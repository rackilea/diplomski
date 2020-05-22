public class DBClass{    
     public Connection getConnection() throws ClassNotFoundException, SQLException{       
           Class.forName("com.mysql.jdbc.Driver");
           return DriverManager.getConnection("jdbc:mysql://192.168.0.1:3306/dbname","mysqluser","mysqluserpwd"); 
     }
}