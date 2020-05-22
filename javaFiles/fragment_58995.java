//Set config
    org.sqlite.SQLiteConfig config = new org.sqlite.SQLiteConfig();
    config.enforceForeignKeys(true);


  //Create JDBC Datasource
    SQLiteConnectionPoolDataSource dataSource = new SQLiteConnectionPoolDataSource();
    dataSource.setUrl("jdbc:sqlite:" + db.toString().replace("\\", "/"));
    dataSource.setConfig(config);