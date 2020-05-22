public class Connection {

    public boolean register() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean connect(String userName, String password) {

        java.sql.Connection conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/cms";
        try {
            DriverManager.getConnection(url, userName, password);
            return true;
        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }

    }
}