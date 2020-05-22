HikariConfig conf = new HikariConfig();

    ....

    conf.setCatalog(DatabaseConfiguration.JDBC_DEFAULT_DATABASE);

    ds = new HikariDataSource(conf);