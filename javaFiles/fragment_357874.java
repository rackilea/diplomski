@Repository
public class DBQuery {

    private final DataSource dataSource;

    @Autowired    
    public DBQuery(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    public ResultSet getAllDataPassport() throws SQLException {

        Connection conn = this.dataSource.getConnection();
        Statement statement = conn.createStatement();
        String sql = "select * from testing_table";
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
}