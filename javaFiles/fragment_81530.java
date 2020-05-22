package mysql;

import java.sql.Connection;

public class MyConnection {

    private Connection connection;

    private boolean isUsed;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isUsed() {
        return isUsed;
    }

}