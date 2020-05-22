/* missing all error handling and resource management*/
universalConnectionPoolManager = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
poolDataSource = PoolDataSourceFactory.getPoolDataSource();
    // setting up dataSource .... 
poolDataSource.setConnectionPoolName(NAME);
universalConnectionPoolManager.createConnectionPool((UniversalConnectionPoolAdapter) poolDataSource);
universalConnectionPoolManager.startConnectionPool(NAME);
universalConnectionPool = universalConnectionPoolManager.getConnectionPool(NAME);
universalPooledConnection = universalConnectionPool.borrowConnection(universalConnectionPool.getConnectionRetrievalInfo());
physicalConnection = universalPooledConnection.getPhysicalConnection();
oracleConn = (OracleConnection) physicalConnection;
    // ... query stuff
universalPooledConnection.heartbeat();
universalConnectionPool.returnConnection(universalPooledConnection);
universalConnectionPoolManager.destroyConnectionPool(NAME);