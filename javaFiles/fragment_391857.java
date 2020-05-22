public class DefaultRolesPrefixPostProcessor implements BeanPostProcessor, PriorityOrdered {

    ...

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof SecurityContextHolderAwareRequestFilter) {
            SecurityContextHolderAwareRequestFilter filter = (SecurityContextHolderAwareRequestFilter) bean;
            filter.setRolePrefix("ROLE_");
        }
        return bean;
    }
}