protected void setCurrentSchema(String identifier) throws Exception {
    if (StringUtils.equalsIgnoreCase(IdentifierEnum.SCHEMA_1.getValue(), identifier) || 
        StringUtils.equalsIgnoreCase(IdentifierEnum.SCHEMA_2.getValue(), identifier)) {
        // WEBSPHERE
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.default_schema", identifier);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = context.getBean(LocalContainerEntityManagerFactoryBean.class);
        entityManagerFactory.setJpaProperties(jpaProperties);
        entityManagerFactory.afterPropertiesSet();

        JpaTransactionManager transactionManager = context.getBean(JpaTransactionManager.class);
        transactionManager.setJpaProperties(jpaProperties);
        transactionManager.afterPropertiesSet();
    } else {
        logger.debug(String.format("INVALID identifier SPECIFIED - %s", identifier));
        throw new RequestParamException(String.format("INVALID identifier SPECIFIED - %s", identifier));
    }
}