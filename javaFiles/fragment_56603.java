public class UnsecuredServiceMethodProcessor implements BeanPostProcessor {
    private static final Logger logger = LogManager.getLogger(UnsecuredServiceMethodProcessor.class);
    private final MethodSecurityInterceptor interceptor;

    public UnsecuredServiceMethodProcessor(MethodSecurityInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (logger.isInfoEnabled()) {
            logger.info("checking bean " + beanName + " of type " + beanClass.getName());
        }
        for (Class<?> interfaceClass: beanClass.getInterfaces()) {
            checkClass(beanClass, interfaceClass);
        }

        return bean;
    }

    /**
     * @param beanClass
     * @param interfaceClass
     */
    private void checkClass(Class<?> beanClass, Class<?> interfaceClass) {
        if (interfaceClass.isAnnotationPresent(Service.class)) {
            if (logger.isDebugEnabled()) {
                logger.debug("found service implementation: " + interfaceClass + " on " + beanClass);
            }
            for (Method method: interfaceClass.getMethods()) {
                if (!method.isAnnotationPresent(Unsecured.class)) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("checking " + method.getName());
                    }
                    MethodSecurityMetadataSource msms = interceptor.getSecurityMetadataSource();
                    Collection<ConfigAttribute> atts = msms.getAttributes(method, interfaceClass);
                    if (atts == null || atts.size() == 0) {
                        logger.warn("unsecured method: " +  method.getDeclaringClass().getName() + "." + method.getName());
                    }
                }
            }
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

}