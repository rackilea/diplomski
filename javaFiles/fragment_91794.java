public final class SQLUtil {
    private static DataSource dataSource;
    // ..

    static {
        try {
            dataSource = (DataSource) new InitialContext().lookup(name);
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {  
        return dataSource.getConnection();             
    }
}