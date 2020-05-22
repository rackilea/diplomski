@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException, PropertyVetoException {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("my.package");
        emf.setJpaVendorAdapter(jpaAdapter());
        emf.setJpaProperties(jpaProterties());
        return emf;
    }