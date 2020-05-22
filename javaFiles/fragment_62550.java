private static LocalSessionFactoryBean generateSessionFactoryBean(String[] basePackage, DataSource dataSource,
        Properties hibernateProperties) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(basePackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        // Added the below line
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean;
    }