public class RemoteEjbExtension implements Extension {

/**
 * This method is fired by the container for every Java EE component class
 * supporting injection that may be instantiated by the container at runtime,
 * including every managed bean declared using javax.annotation.ManagedBean,
 * EJB session or message-driven-bean, enabled bean, enabled interceptor or
 * enabled decorator.
 *
 * @param pit the event that has been fired
 */
<T> void processInjectionTarget(@Observes final ProcessInjectionTarget<T> pit) {
    for (AnnotatedField<? super T> field : pit.getAnnotatedType().getFields()) {
        if (field.getJavaMember().getType().isAnnotationPresent(Remote.class)) {
            RemoteProxyFactory.putIfAbsent(field.getJavaMember().getType());
        }
    }
}

/**
 * This method is fired by the container when it has fully completed the
 * bean discovery process, validated that there are no definition errors
 * relating to the discovered beans, and registered Bean and ObserverMethod
 * objects for the discovered beans, but before detecting deployment problems.
 *
 * @param abd AfterBeanDiscovery fired events
 * @param bm Allows a portable extension to interact directly with the container.
 *          Provides operations for obtaining contextual references for beans,
 *          along with many other operations of use to portable extensions.
 */
@SuppressWarnings("unchecked")
void afterBeanDiscovery(@Observes final AfterBeanDiscovery abd, final BeanManager bm) {

    // Roll over discovered remote interfaces
    for (final Entry<String, Class<?>> remoteClassEntry : RemoteProxyFactory.getProxyClassEntries()) {

        // Proxy that points to the remote EJB
        final Object remoteProxy;
        final Class<?> remoteClass = remoteClassEntry.getValue();

        try {
            // Build a proxy that fetches the remote EJB using JNDI
            // and delegate the call.
            remoteProxy = RemoteProxyFactory.Builder.createEJBRemoteProxy(remoteClass);
        } catch (Exception e) {
            throw new IllegalStateException("Proxy creation for " + remoteClass.getCanonicalName() + " failed.", e);
        }

        final InjectionTarget<Object> it;
        try {
            AnnotatedType<Object> at = ((AnnotatedType<Object>) bm.createAnnotatedType(remoteProxy.getClass()));
            it = bm.createInjectionTarget(at);
        } catch (Exception e) {
            throw new IllegalStateException("Injection target for " + remoteClass.getCanonicalName() + " is invalid.", e);
        }

        final Bean<?> beanRemoteProxy = RemoteProxyFactory.Builder.createBeanForProxy(remoteProxy, it, remoteClass, ApplicationScoped.class);
        abd.addBean(beanRemoteProxy);
    }

}
}