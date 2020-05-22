public class DynamicContextExtension implements Extension {

    private final Set<Class<? extends Annotation>> scopes = new HashSet<>();

    public void processBean(@Observes ProcessBean<?> bean) {
        Class<? extends Annotation> scope = bean.getBean().getScope();
        if (scope.isAnnotationPresent(DynamicScope.class)) {
            this.scopes.add(scope);
        }
    }

    public void afterBeanDiscovery(@Observes AfterBeanDiscovery afterBeanDiscovery, BeanManager beanManager) {
        for (Class<? extends Annotation> scope : scopes) {
            DynamicScope dynamicScope = scope.getAnnotation(DynamicScope.class);
            try {
                // TODO use a managed DynamicContextActivation instead of instantiating it here
                DynamicContextActivation activation = dynamicScope.activation().newInstance();
                Context context = new DynamicContext(beanManager, activation, scope, dynamicScope.value());
                afterBeanDiscovery.addContext(context);
            } catch (InstantiationException | IllegalAccessException exception) {
                afterBeanDiscovery.addDefinitionError(exception);
            }
        }
    }
}