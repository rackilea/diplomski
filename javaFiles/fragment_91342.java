@Configuration
public static class DevelopmentConfig{

    @PreDestroy
    public void shutdown() {
        final String SHUTDOWN_CODE = "XJ015";
        System.out.println("SHUTTING DOWN");

        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {
            // Derby 10.9.1.0 shutdown raises a SQLException with code "XJ015"
            if (!SHUTDOWN_CODE.equals(e.getSQLState())) {
                e.printStackTrace();
            }
        }
    }

    /* if needed ...
    @PostConstruct
    public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
    }
    */
    @Bean
    public DataSource dataSource() throws SQLException, PropertyVetoException {

        DataSource dataSource = new SimpleDriverDataSource(new org.apache.derby.jdbc.EmbeddedDriver(), "jdbc:derby:C:\\Users\\Kevin\\Desktop\\DerbyDB", "", "");

        System.out.println("RETURNING DATASOURCE");

        return dataSource;

    }

    // remaining of code unchanged