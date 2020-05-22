public YourBeanPostProcessor implements BeanPostProcessor {

    public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof YourBean) {
            ProxyFactory factory = new ProxyFactory(bean);
            factory.setProxyTargetClass(true);
            return factory.getProxy();
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}