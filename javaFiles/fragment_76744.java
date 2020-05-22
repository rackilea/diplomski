import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectivity {
    Connection connection;
    String url, user, pass, driver;

    public Connectivity(String url, String user, String pass, String driver) {
        super();
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
        try{
             Class.forName(driver);
             connection = DriverManager.getConnection(url, user, pass);

            }catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public Statement getStatement() throws SQLException{
             return connection.createStatement();

    }

    public void close() throws SQLException{
        connection.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();
    }
}