@Override
public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("test"); // get the bean definition in some way
    if (beanDefinition != null) {
        beanDefinition.getPropertyValues().removePropertyValue("other"); // remove the property value based on some criterion
    }
}