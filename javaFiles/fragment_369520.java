@RequestScoped
public class ConnectionWrapper {

@Resource(lookup = "java:/MyDBName")
private DataSource dataSource;

private Connection connection;

@PostConstruct
public void init() throws SQLException {
    this.connection = dataSource.getConnection();
}

@PreDestroy
public void destroy() throws SQLException {
    this.connection.close();
}

public void begin() throws SQLException {
    this.connection.setAutoCommit(false);
}

public void commit() throws SQLException {
    this.connection.commit();
    this.connection.setAutoCommit(true);
}

public void rollback() throws SQLException {
    this.connection.rollback();
    this.connection.setAutoCommit(true);
}

public Connection getConnection() {
    return connection;
}
}