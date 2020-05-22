public class PostProxySpringContextListener implements ApplicationListener<ContextRefreshedEvent> {

private static Logger LOG = LoggerFactory.getLogger(PostProxySpringContextListener.class);

@Override
public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext context = event.getApplicationContext();
    String[] beanDefinitionNames = context.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
        String originalClassName = getOriginalClassName(beanDefinitionName, event);
        if (originalClassName != null) {
            invokeAnnotatedMethods(context, beanDefinitionName, originalClassName);
        }
    }
}

private String getOriginalClassName(String name, ContextRefreshedEvent event) {
    try {
        ConfigurableListableBeanFactory factory =
                (ConfigurableListableBeanFactory)event.getApplicationContext().getAutowireCapableBeanFactory();
        BeanDefinition beanDefinition = factory.getBeanDefinition(name);
        return beanDefinition.getBeanClassName();
    } catch (NoSuchBeanDefinitionException e) {
        LOG.debug("Can't get bean definition for : " + name);
        return null;
    }
}

private void invokeAnnotatedMethods(ApplicationContext context, String beanDefinitionName, String originalClassName) {
    try {
        Class<?> originalClass = Class.forName(originalClassName);
        Method[] methods = originalClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostProxy.class)) {
                LOG.info("Executing @PostProxy annotated initialization method: " + method.toString());
                Object bean = context.getBean(beanDefinitionName);
                Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                currentMethod.invoke(bean);
            }
        }
    } catch (ClassNotFoundException e) {
        LOG.trace("No class instance for bean " + beanDefinitionName + " with class name " + originalClassName);
    } catch (NoSuchMethodException e) {
        LOG.error("Error finding @PostProxy method for bean " + beanDefinitionName, e);
    } catch (InvocationTargetException e) {
        LOG.error("Error invoking @PostProxy method for bean " + beanDefinitionName, e);
    } catch (IllegalAccessException e) {
        LOG.error("Can't invoke annotated method in bean" + beanDefinitionName + " with class name " + originalClassName
                + ". Please check access modifiers on @PostProxy methods.", e);
    }
}
}