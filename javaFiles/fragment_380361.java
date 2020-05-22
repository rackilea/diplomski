// Hostname
private static final String dbHost = "127.0.0.1";

// Port -- Standard: 3306
private static final String dbPort = "3306";

// Database name
private static String database = "database"; //

// Database user
private static final String dbUser = "root";

// Datenbankpasswort
private static final String dbPassword = "";

private Statement s;


public void Connect() {
    try {
        Class.forName("java.sql.Driver"); // load driver
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + database + "?" + "user=" + dbUser + "&"
                + "password=" + dbPassword); // try to connect with your attributes 
        s = conn.createStatement();
    } catch (ClassNotFoundException e) { // 
        l.error("Driver not found " + e);
    } catch (SQLException e) {
        l.error("Connect not possible" + e);
    }
}