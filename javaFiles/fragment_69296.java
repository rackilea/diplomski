public DataSource setUpPool() throws Exception {

Class.forName(JDBC_DRIVER);
// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);
// Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!

ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

// Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!


PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);

return new PoolingDataSource(gPool);
}