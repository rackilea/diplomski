public static Connection dbConnector() {
    if (con == null) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Successful!");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Connection Unsuccessful.");
        }
    }
    return con;
}