import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static Connection getMySQLConnection() throws Exception {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost/databaseName";
    String username = "root";
    String password = "root";
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
  }

  public static void main(String args[]) {
    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getMySQLConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select timeCol, dateCol, dateTimeCol from dateTimeTable");
      while (rs.next()) {
        java.sql.Time dbSqlTime = rs.getTime(1);
        java.sql.Date dbSqlDate = rs.getDate(2);
        java.sql.Timestamp dbSqlTimestamp = rs.getTimestamp(3);
        System.out.println("dbSqlTime=" + dbSqlTime);
        System.out.println("dbSqlDate=" + dbSqlDate);
        System.out.println("dbSqlTimestamp=" + dbSqlTimestamp);

        java.util.Date dbSqlTimeConverted = new java.util.Date(dbSqlTime.getTime());
        java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
        System.out.println("in standard date");
        System.out.println(dbSqlTimeConverted);
        System.out.println(dbSqlDateConverted);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        stmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}