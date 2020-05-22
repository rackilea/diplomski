class MyDatasourceRegisteringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        //Read in details from legacy properties.. build custom bean definitions and register with bean factory
        //for each legacy property...
            BeanDefinitionBuilder datasourceDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(BasicDataSource.class).addPropertyValue("url", "jdbc..");
            beanFactory.registerBeanDefinition(datasourceDefinitionBuilder.getBeanDefinition());
    }
}