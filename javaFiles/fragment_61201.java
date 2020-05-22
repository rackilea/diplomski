import java.sql.*;

public class JDBCQuery {
    public static void main( String args[] )
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};" + 
                    "Dbq=C:\\Users\\Public\\uls\\ulsTest.mdb;" +
                    "SystemDB=C:\\Users\\Public\\uls\\Security.mdw;" +
                    "Uid=Gord;" +
                    "Pwd=obfuscated;" +
                    "ExtendedAnsiSQL=1;");
            Statement s = conn.createStatement();
            s.execute("CREATE USER Tim pwd");
            System.out.println("User 'Tim' created.");
            s.execute("DROP USER Tim");
            System.out.println("User 'Tim' dropped.");
            s.close();
            conn.close();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}