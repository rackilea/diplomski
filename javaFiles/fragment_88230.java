BasicDataSource ds = new BasicDataSource();
ds.setDriverClassName(JDBCDriver);
ds.setUrl(JDBCUrl);
ds.setUsername(JDBCUser);
ds.setPassword(JDBCPassword);
ds.setInitialSize(initSize);
ds.setTestOnBorrow(false);
ds.setTestWhileIdle(true);