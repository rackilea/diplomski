@Inject
private BeanManager beanManager;

public <T extends Object> T performInjection(final T obj) {
    if (this.beanManager != null) { // only do injection if the bean manager is present.
        // Create a creational context from the BeanManager
        final CreationalContext creationalContext = this.beanManager.createCreationalContext(null);
        // Create an injection target with the Type of the instance we need to inject into
        final InjectionTarget injectionTarget = this.beanManager.createInjectionTarget(this.beanManager.createAnnotatedType(obj.getClass()));
        // Perform injection into the instance
        injectionTarget.inject(obj, creationalContext);
        // Call PostConstruct on instance
        injectionTarget.postConstruct(obj);
    }
    return obj;
}