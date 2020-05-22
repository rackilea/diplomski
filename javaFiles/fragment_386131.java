public static Connection getConnection() throws ClassNotFoundException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Properties env = new Properties();

    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
    env.put(Context.PROVIDER_URL, "file:/C://JNDI");

    Connection connection = null;

    try {
        InitialContext context = new InitialContext(env);
        DataSource dataSource = (DataSource) context.lookup("jdbc/DataSource");
        connection = dataSource.getConnection();
    } catch (NamingException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return connection;
}