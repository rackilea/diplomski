Connection connection = null;

try {
    // Load the JDBC driver
    String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
    Class.forName(driverName);

    // Create a connection to the database
    String serverName = "localhost";
    String mydatabase = "mydatabase";
    String url = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
    String username = "username";
    String password = "password";
    connection = DriverManager.getConnection(url, username, password);
} catch (ClassNotFoundException e) {
    // Could not find the database driver
} catch (SQLException e) {
    // Could not connect to the database
}