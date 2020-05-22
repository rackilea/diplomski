public class CreateConnection {
    String driver = "com.mysql.jdbc.Driver";
    String DB_username = "username";
    String DB_password = "password";
    String DB_URL = "jdbc:mysql://192.168.100.10:3306/flats_flx";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            System.out.println(con);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }
}