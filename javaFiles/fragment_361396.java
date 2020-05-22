@Component
public class DataSourceManager implements DataSource{

    private DataSource dataSource;

    @PostConstruct
    @Scheduled(fixedRate=1000)
    public void reload() {
        // init the datasource
    }

    public DataSource getDataSource(String dbName) {
        return dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    .... wrap all the other DataSource methods

}