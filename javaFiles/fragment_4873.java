@Bean
public LocalSessionFactoryBean localSessionFactoryBean(DataSource ds) throws ClassNotFoundException {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(dataSource());
    localSessionFactoryBean.setPackagesToScan("com.app.persistence.model");
    return localSessionFactoryBean;
}