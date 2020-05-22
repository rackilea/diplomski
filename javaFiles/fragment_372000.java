import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class TestDatabaseMetaDataToolDatabaseInformation {
  public static void main(String[] args) {
    Connection conn = getOracleConnection();
    DatabaseMetaData meta = conn.getMetaData();
    // Oracle (and some other vendors) do not support
    // some the following methods; therefore, we need
    // to use try-catch block.
    try {
      int majorVersion = meta.getDatabaseMajorVersion();
      System.out.println("major Version: " + majorVersion);
      int minorVersion = meta.getDatabaseMinorVersion();
      System.out.println("minorVersion" + minorVersion);
      String productName = meta.getDatabaseProductName();
      String productVersion = meta.getDatabaseProductVersion();
      System.out.println("productName" + productName);
      System.out.println("productVersion" + productVersion);
    } catch (SQLException e) {
      System.out.println("minorVersion unsupported feature");
      System.out.println("major Version: unsupported feature");
    } finally {
        conn.close();
    }
  }

  public static Connection getOracleConnection() throws Exception {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:databaseName";
    String username = "name";
    String password = "password";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

}