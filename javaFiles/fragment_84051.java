import java.sql.*;

public class JDBCQuery {

    public static void main(String args[]) {
        Connection conn = null;
        Statement s = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={SQL Server};" + 
                    "Server=.\\SQLEXPRESS;" +
                    "Trusted_Connection=yes;" +
                    "Database=myDb");
            s = conn.createStatement();
            s.executeQuery("SELECT * FROM dbo.SalesSummary WHERE 0 = 1");
            ResultSet rs = s.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(String.format("-- Column %d --", i));
                System.out.println(String.format("Column name: %s", rsmd.getColumnName(i)));
                System.out.println(String.format("Database-specific type name: %s", rsmd.getColumnTypeName(i)));
                System.out.println(String.format("Column size (DisplaySize): %d", rsmd.getColumnDisplaySize(i)));
                System.out.println(String.format("java.sql.Type of column: %d", rsmd.getColumnType(i)));
                System.out.println();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
}