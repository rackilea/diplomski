import java.io.*;
import java.sql.*;

public class Db {
    private final String url;
    ResultSet resultSet = null;
    Statement statement = null;
    final String driver;
    String user = "";
    String database = "";
    String password = "";
    String port = "";
    String host = "";
    Connection c = null;

    public Db(String Host, String db, String username, String password) {
        this.host = Host;
        this.database = db;
        this.user = username;
        this.password = password;
        url = "jdbc:mysql://" + host + "/" + database + "?user=" + user
                + "&password=" + password;
        driver = ("com.mysql.jdbc.Driver");
    }

    public Db(String filePath) {
        url = "jdbc:sqlite:" + new File(filePath).getAbsolutePath();
        driver = ("org.sqlite.JDBC");
    }

    public Connection open() {
        try {
            Class.forName(driver);
            this.c = DriverManager.getConnection(url);
            return c;
        } catch (SQLException e) {
            System.out
                    .println("Could not connect to MySQL/SQLite server! because: "
                            + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
        }
        return this.c;
    }

    public boolean checkConnection() {
        if (this.c != null) {
            return true;
        }
        return false;
    }

    public Connection getConn() {
        return this.c;
    }

    public void closeConnection(Connection c) {
        c = null;
    }
}