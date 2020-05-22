import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class CreatingDerbyDJB 
{
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL  = "jdbc:derby:LostAndFoundDB";
    public static Connection dbConnection()
    {
        try
        {
            Class.forName(DRIVER).newInstance();
            Connection c = DriverManager.getConnection(JDBC_URL);
            return c;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}