@Bean(name="dataSource")
public DataSource dataSource() throws PropertyVetoException {

    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
    hibernateProperties.put("hibernate.show_sql", false);
    hibernateProperties.put("hibernate.generate_statistics", false);
    hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
    hibernateProperties.put("hibernate.use_sql_comments", false);

    //note the "hibernate.c3p0...." properties are no longer in use

    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    dataSource.setDriverClass(jobDatabaseProperties.getJobDatabaseDriverClassName());
    dataSource.setJdbcUrl(jobDatabaseProperties.getJobDatabaseUrl());
    dataSource.setUser(jobDatabaseProperties.getJobDatabaseUsername());
    dataSource.setPassword(jobDatabaseProperties.getJobDatabasePassword());

    dataSource.setAcquireIncrement(1);
    dataSource.setMinPoolSize(5);
    dataSource.setMaxPoolSize(100);
    dataSource.setMaxIdleTime(20);

    return new dataSource;
}