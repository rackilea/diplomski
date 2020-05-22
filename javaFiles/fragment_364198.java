BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName(db_driver_name);
dataSource.setUrl(db_connection_url);
dataSource.setUsername(db_username);
dataSource.setPassword(db_password);
SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
builder.bind(jndi_name, dataSource);
builder.activate();