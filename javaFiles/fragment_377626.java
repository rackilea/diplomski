// Setup the datasource
DataSource ds = new OracleDataSource();// There is other DataSource offered by Oracle , check the javadoc for more information
ds.setDriverType("thin");
ds.setServerName("myServer");
ds.setPortNumber(1521);
ds.setDatabaseName("myDB");
ds.setUser("SCOTT");
ds.setPassword("TIGER");

// Get a JDBC connection
Connection c = ds.getConnection();