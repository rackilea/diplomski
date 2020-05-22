package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import com.mysql.jdbc.Driver;

/**
 * @author decorrea
 *
 */
public class DBUtils {

    public static String jdbc_driver_name = "com.mysql.jdbc.Driver";    

    private static String server_name ;
    private static String database;
    private static String username;
    private static String password;

    private static int maxActive = 20;
    private static int maxIdle = 2 ; 

    public String getServer_name() {
        return server_name;
    }

    public void setServer_name(String serverName) {
        server_name = serverName;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static DataSource getDataSource(String server_name, String database, String username, String password){

        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(jdbc_driver_name);
        String url = "jdbc:mysql://" + server_name +  "/" + database;
        System.out.println(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setUrl(url);
        datasource.setMaxActive(maxActive);
        datasource.setMaxIdle(maxIdle);
        return datasource;
    }
}