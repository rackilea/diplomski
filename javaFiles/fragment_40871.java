import java.sql.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:test;sql.ignore_case=true", "SA", "");
    Statement stmt = c.createStatement();
    stmt.executeUpdate("CREATE TABLE TeSt(NAME VARCHAR(99))");
    stmt.executeUpdate("INSERT INTO tEsT (NAME) VALUES ('ABC')");
    ResultSet rs = stmt.executeQuery("SELECT * FROM TesT WHERE NAME = 'abc'");
    rs.next();
    System.out.println(rs.getString(1)); // prints: ABC
  }
}