import java.sql.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:test", "SA", "");
    Statement stmt = c.createStatement();
    stmt.executeUpdate("CREATE TABLE TEST(ID INT)");
    stmt.executeQuery("SELECT id FROM test;");
  }
}