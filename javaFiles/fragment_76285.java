public class DeferredConnectionProvider implements ConnectionProvider {

    private Properties configuredProps;
    private ConnectionProviderImpl realConnectionProvider;

    @Override
    public void configure(Properties props) throws HibernateException {
        configuredProps = props;
    }

    public void finalConfiguration(String jdbcUrl, String userName, String password) {
        configuredProps.setProperty(Environment.URL, jdbcUrl);
        configuredProps.setProperty(Environment.USER, userName);
        configuredProps.setProperty(Environment.PASS, password);

        realConnectionProvider = new ConnectionProviderImpl();
        realConnectionProvider.configure(configuredProps);
    }

    private void assertConfigured() {
        if (realConnectionProvider == null) {
            throw new IllegalStateException("Not configured yet!");
        }
    }        

    @Override
    public Connection getConnection() throws SQLException {
        assertConfigured();

        return realConnectionProvider.getConnection();
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        assertConfigured();

        realConnectionProvider.closeConnection(conn);
    }

    @Override
    public void close() throws HibernateException {
        assertConfigured();

        realConnectionProvider.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        // This gets called during EntityManagerFactory construction, but it's 
        // just a flag so you should be able to either do this, or return
        // true/false depending on the actual provider.
        return new ConnectionProviderImpl().supportsAggressiveRelease();
    }
}