import java.sql.*;

public class NewClass {

    public static void main(String[] args) {
        Connection conn = null;
      String mysqlPath="c:/Program Files/MySQL/MySQL Server 5.1/bin";
        String url = "jdbc:mysql://192.168.100.86/";
        String databaseIp="192.168.100.86";
        String dbName = "databasename";
        java.sql.Statement stmt = null;
        String query = "";
        ResultSet result = null;
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();            
            conn = DriverManager.getConnection(url , userName, password);
            stmt = conn.createStatement();
            result = null;
            String test,input;
            stmt.execute("drop database if exists  "+dbName);
            String fullPathWithArgs ="C:/ba.bat \""+mysqlPath+"\" "+databaseIp+" "+userName+" "+password+"";
            Process runtimeProcess =Runtime.getRuntime().exec(fullPathWithArgs);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0)
                      {
                           System.out.println("DatabaseManager.restore: Restore Successfull");
                      }
            else
                  {
                     System.out.println("DatabaseManager.restore: Restore Failure!");
                  }

            conn.close();
        } catch (Exception e) {           
            System.out.println("exception: " + e.getMessage());
        }
    }
}