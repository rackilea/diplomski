public Connection getConnection() throws Exception {
    /* Define the database to be used, the driver,
    * the connection url, and the username and
    * password to connect the database
    */
    if (connection == null) {
        driver = "com.informix.jdbc.IfxDriver";
        Class.forName(driver);
        connectionURL = "jdbc:informix-sqli://127.0.0.1:9090/barubuat:informixserver=lo_informix1210;user=informix;password=abc123";
        connection = DriverManager.getConnection(connectionURL);
    }
    return connection;
}