import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DescribeDB {
  public static void main( String[] args )
  {
    try{
      Class.forName("oracle.jdbc.OracleDriver");

      Connection con = DriverManager.getConnection(
                         "jdbc:oracle:thin:@localhost:1521:XE",
                         "username",
                         "password"
                       );

      DatabaseMetaData md = con.getMetaData();

      ResultSet rs = md.getImportedKeys(
                          con.getCatalog(),
                          "TEST",
                          "CHILD_TABLE"
                        );

      while (rs.next()) {
        System.out.println(
            String.format(
                "%s.%s.%s references %s.%s.%s",
                rs.getString("FKTABLE_SCHEM"),
                rs.getString("FKTABLE_NAME"),
                rs.getString("FKCOLUMN_NAME"),
                rs.getString("PKTABLE_SCHEM"),
                rs.getString("PKTABLE_NAME"),
                rs.getString("PKCOLUMN_NAME")
            )
        );
      }
    } catch(ClassNotFoundException | SQLException e) {
      System.out.println(e);
    }
  }
}