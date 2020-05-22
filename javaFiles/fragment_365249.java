class DefaultSchemaDelegatingDS extends DelegatingDataSource {
    private final String catalogName;

    public DefaultSchemaDelegatingDS(final String catalogName, final DataSource dataSource) {
        super(dataSource);
        this.catalogName = catalogName;
    }

    @Override
    public Connection getConnection() throws SQLException {
        final Connection connection = super.getConnection();
        connection.setCatalog(this.catalogName);
        return connection;
    }
}