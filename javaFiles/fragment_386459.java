public static void main(String[] args) {
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    BeanDefinition beanDefinition = BeanDefinitionBuilder
            .rootBeanDefinition(Arrays.class, "asList")
            .addConstructorArgValue(args)
            .getBeanDefinition();
    beanFactory.registerBeanDefinition("args", beanDefinition);

    GenericApplicationContext parentContext= new GenericApplicationContext(beanFactory);
    parentContext.refresh();
    ...
}