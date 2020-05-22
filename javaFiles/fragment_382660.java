final HikariConfig hikariConfig = new HikariConfig();
hikariConfig.setPoolName("SQLite");
hikariConfig.setDataSourceClassName("org.sqlite.SQLiteDataSource");
hikariConfig.addDataSourceProperty("url", "jdbc:sqlite:C:/work/mydatabase.db");
hikariConfig.addDataSourceProperty("journalMode", "WAL");
hikariConfig.addDataSourceProperty("fullColumnNames", "true");

HikariDataSource ds = new HikariDataSource(hikariConfig);