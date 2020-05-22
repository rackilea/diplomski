public class DBConnect {

    private Connection con;

    public DBConnect() {
        // setup con
    }

    public Connection getConnection() {
        return con; // con is never null because it's been initialised in constructor
    }

    ...