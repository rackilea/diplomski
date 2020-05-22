@Override
public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    registerTargetTransactionPolicy(datasources.get("target"), registry);
    for (Entry<String, BasicDataSource> source : datasources.entrySet()) {
        LOG.info("Adding datasource {} targeting {} to Spring registry", source.getKey(), source.getValue().getUrl());
        registry.registerBeanDefinition(source.getKey(), BeanDefinitionBuilder.genericBeanDefinition(BasicDataSource.class, () -> source.getValue()).getBeanDefinition());
    }
}

private void registerTargetTransactionPolicy(BasicDataSource datasource, BeanDefinitionRegistry registry) {
    PlatformTransactionManager transactionManager = new DataSourceTransactionManager(datasource);
    SpringTransactionPolicy transactionPolicy = new SpringTransactionPolicy(transactionManager);
    transactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRES_NEW");
    registry.registerBeanDefinition(TARGET_REQUIRES_NEW_POLICY, BeanDefinitionBuilder.genericBeanDefinition(SpringTransactionPolicy.class, () -> transactionPolicy).getBeanDefinition());
}