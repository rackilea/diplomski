package stack.filter;

import java.sql.Connection;
import java.sql.DriverManager;
public class JDBCConnector {        
public static Connection connect_database(){
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/work", "root", "root");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(con!=null)
        {
            System.out.println("Connected...");
        }
    }
    return con;
}
}