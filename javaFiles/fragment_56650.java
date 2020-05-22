@Bean(name="dataSourceRedshift")
public DataSource dataSourceRedshift() throws SQLException, JSchException {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(new com.amazon.redshift.jdbc41.Driver());
    dataSource.setUrl("jdbc:postgresql://" + redshiftHost + ":" + redshiftPort + "/" + redshiftDatabase);
    dataSource.setUsername(redshiftUser);
    dataSource.setPassword(redshiftPass);

    DefaultSessionFactory defaultSessionFactory = new DefaultSessionFactory();

    TunneledDataSourceWrapper tunneledDataSource = new TunneledDataSourceWrapper(
            new TunnelConnectionManager(
                    defaultSessionFactory,
                    redshiftTunnel ),
            dataSource );

    return tunneledDataSource;
}