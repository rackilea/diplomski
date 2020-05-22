public void startConnection() throws Exception {
            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    }

public void compareData(int id, String pass) throws SQLException{
        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        String query = "SELECT id, password FROM users WHERE id=?, password=?";

        try {
            conn.startConnection();
        } catch (Exception e) {
            throw new SQLException(e);
        }