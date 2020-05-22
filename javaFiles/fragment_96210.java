private Connection conDb;

public Connection getConnection() {
    return conDb;
}

public DbManager(String url, String username, String password) {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        this.conDb = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
        System.out.println(e);
    }

}