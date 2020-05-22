public class DBConnection {

   private static final String URL = "jdbc:derby://localhost:1527/Bank";
   private final  Connection conn;
   private final Statement st;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection(URL, "test", "test");
        st = conn.createStatement();
    }

    public Statement getSt() {
        return st;
    }
}