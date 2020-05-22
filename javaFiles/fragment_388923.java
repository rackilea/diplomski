public class TableConnectionInfo {

    private String url;
    private String user;
    private String password;
    private String driver;
    private String suffix;
    private String sql;

private Connection connection;

<snip... getters and setters for the properties>

public Connection getConnection() {
    // TODO  create and return a connection
    if (connection == null) {
        // create the connection
    }
    return connection;
}

public CallableStatement getCallableStatement() {
    // get the callable statement
    return null;
}

public Collection<Method> getMethods() {
    // Get the Methods
    return null;
}

}

public class TableTask implements Runnable {

private Collection<TableConnectionInfo> tables;

public TableTask(Collection<TableConnectionInfo> tables) {
    this.tables = tables;
}

@Override
public void run() {
    for (TableConnectionInfo table : tables) {
        // do something with table.getConnection(), or table.getCallableStatement()
        // and/or table.getMethods()
    }
}

}