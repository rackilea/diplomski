import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    static StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    static String serverName ="192.168.1.1";
    static String serverPort ="1433";
    static String databaseName ="DatabaseName";
    static String db = String.format("jdbc:jtds:sqlserver://%s:%s/%s", serverName, serverPort, databaseName);
    static String un = "Username";
    static String pass = "Password";
    static Connection con;


    public static Connection getConnection() {
        try {
            try {
                StrictMode.setThreadPolicy(policy);
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                con = DriverManager.getConnection(db, un, pass);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}