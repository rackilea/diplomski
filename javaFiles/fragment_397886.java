public final class DataSourceUtil {
    /**
     * Private constructor to prevent unnecessary instantiations
     */
    private DataSourceUtil() {
    }

    public static DataSource getDataSource(String name) {
        try {
            Context ctx = new InitialContext();
            String database = "jdbc/" + name;
            return (javax.sql.DataSource) ctx.lookup (database);
        }
        catch (NamingException e) {
            throw new IllegalStateException("Error accessing JNDI and getting the database named " + name);
        }
    }
}