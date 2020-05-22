@Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf) throws BeansException {
        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) clbf;
        beanDefinitionRegistry.removeBeanDefinition("testerBean");


    }

}