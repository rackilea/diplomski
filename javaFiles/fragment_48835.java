@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource dataSource,
            final JpaVendorAdapter jpaVendorAdapter) {
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("domainPC");
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());
        Properties jpaProperties = new Properties();
        //and here is your flushMode set.
        jpaProperties.setProperty("org.hibernate.flushMode", "COMMIT");
        factory.setJpaProperties(jpaProperties);

        return factory;
    }