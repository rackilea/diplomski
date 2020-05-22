@Override
public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
    System.out.println("Before Initialization : " + beanName);
    return bean;
}

@Override
public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
    System.out.println("After Initialization : " + beanName);
    return bean;
}