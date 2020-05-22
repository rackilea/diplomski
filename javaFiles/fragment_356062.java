public final class DataSourceConnection {
    // This defines an instance of the class
    private BasicDataSource dataSource;
    private DataSourceConnection(String driver, String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        this.dataSource.setDriverClassName(driver);
        this.dataSource.setUrl(url);
        this.dataSource.setUsername(username);
        this.dataSource.setPassword(password);
    }
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
    // This defines the "shared"/"multiple singleton" instances
    public static final DataSourceConnection DATABASE1 = new DataSourceConnection("...", "...", "...", "...");
    public static final DataSourceConnection DATABASE2 = new DataSourceConnection("...", "...", "...", "...");
    public static final DataSourceConnection DATABASE3 = new DataSourceConnection("...", "...", "...", "...");
}