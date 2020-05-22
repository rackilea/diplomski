@Configuration
public static class DevelopmentConfig{
    EmbeddedDatabaseFactory dsFactory;

    public DevelopmentConfig() {
        EmbeddedDatabaseConfigurer configurer = new EmbeddedDatabaseConfigurer() {
            @Override
            public void configureConnectionProperties(ConnectionProperties properties, String databaseName) {
                System.out.println("CONFIGURE");

                properties.setDriverClass(org.apache.derby.jdbc.EmbeddedDriver.class);
                properties.setUrl("jdbc:derby:C:\\Users\\Kevin\\Desktop\\DerbyDB");
            }

            @Override
            public void shutdown(DataSource dataSource, String databaseName) {
                final String SHUTDOWN_CODE = "XJ015";
                System.out.println("SHUTTING DOWN");

                try {
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");
                } catch (SQLException e) {
                    // Derby 10.9.1.0 shutdown raises a SQLException with code "XJ015"
                    if (!SHUTDOWN_CODE.equals(e.getSQLState())) {
                        e.printStackTrace();;
                    }
                }
            }
        };
        dsFactory = new EmbeddedDatabaseFactory();
        dsFactory.setDatabaseConfigurer(configurer);
    }

    @Bean
    public DataSource dataSource() throws SQLException, PropertyVetoException {

        System.out.println("RETURNING DATASOURCE");

        return dsFactory.getDatabase();
    }

    // remaining of code unchanged