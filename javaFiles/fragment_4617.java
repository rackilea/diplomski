public class ConnectionProvider {
    private static DataSource dataSource;
    private static boolean initialized = false;

    public static void init(Map<String, String> conf) {
        if (!initialized) {
            //synchronization to avoid multiple threads accesing to this part of the method
            //at the "same time"
            synchronized(DataSourceProvider.class) {
                //double validation in case of multi threaded applications
                if (!initialized) {
                    //you may add more validations here
                    //in case you want to use another datasource provider
                    //like C3PO, just change this part of the code
                    BoneCPDataSource bds = new BoneCPDataSource();
                    bds.setDriverClass(conf.get("driver"));
                    bds.setJdbcUrl(conf.get("url"));
                    bds.setUsername(conf.get("user"));
                    bds.setPassword(conf.get("password"));
                    //this should be obtained as configuration parameter
                    bds.setMaxConnectionsPerPartition(2);
                    //you can add more BoneCP specific database configurations
                    dataSource = bds;
                    initialized = true;
                }
            }
        }
    }

    public static Connection getConnection() {
        if (dataSource == null) {
            //this should be a custom exception in your app
            throw new RuntimeException("Data Source was not initialized.");
        }
        return dataSource.getConnection();
    }
}