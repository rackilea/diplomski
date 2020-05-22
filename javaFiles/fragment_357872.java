@Repository
public class DBQuery {

    @Autowired
    private Environment env;
    String dbUsername = env.getProperty("db.username");
    String dbPassword = env.getProperty("db.password");
    String dbUrl = env.getProperty("db.url");
    String start; 

    public ResultSet getAllDataPassport() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = conn.createStatement();
        String sql = "select * from testing_table";
        ResultSet rs = statement.executeQuery(sql);

        return rs;
    }
}