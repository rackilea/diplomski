@Bean
public LocalSessionFactoryBean sessionfactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setHibernateProperties(getproperties());
    sessionFactoryBean.setDataSource(datasource);
    sessionFactoryBean.setPackagesToScan( new String[] {"com.boto.SpringHibernatee.entity"});

    return sessionFactoryBean;
}