public class SQLConnector 
{
    private static final String DB_NAME = "jdbc/LibraryManagementSystem";
    private static Connection connection;

    public static Connection getDatabaseConnection() {

        try {
            Context initContext  = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource)envContext.lookup(DB_NAME);
            connection = dataSource.getConnection();
        } 
        catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}