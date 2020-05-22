private final DefaultListableBeanFactory factory = (DefaultListableBeanFactory) applicationContext
        .getAutowireCapableBeanFactory();

private void registerBean(String beanName, String scope) throws IOException {

    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    genericBeanDefinition.setBeanClassName("org.jibeframework.core.util.ViewComponentFactory");
    genericBeanDefinition.setScope(scope);
    genericBeanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_NO);
    genericBeanDefinition.setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_NONE);
    BeanDefinitionHolder holder = new BeanDefinitionHolder(genericBeanDefinition, beanName, new String[] {});
    BeanDefinitionReaderUtils.registerBeanDefinition(holder, factory);

}