public final class RemoteProxyFactory {

/** The JNDI initial context */
private static InitialContext CTX;
static {
    try {
        RemoteProxyFactory.CTX = new InitialContext();
    } catch (NamingException e) {
        throw new IllegalStateException("Unable to get initial context.", e);
    }
}

private static final Map<String, Class<?>> REMOTE_EJB_CLASS_MAP = new ConcurrentHashMap<String, Class<?>>();

/**
 * Register given class into proxy map
 * @param remoteEJBContractClass the remote contract's class to register
 */
public static void putIfAbsent(final Class<?> remoteEJBContractClass) {
    // Works only for same class-loader. You would change this code
    // and transform the map to handle multiple class-loader for same contract.
    // In our current configuration there is no need as APIs / IMPL libraries share the same CL.
    if (!REMOTE_EJB_CLASS_MAP.containsKey(remoteEJBContractClass.getSimpleName())) {
        REMOTE_EJB_CLASS_MAP.put(remoteEJBContractClass.getSimpleName(), remoteEJBContractClass);
    }
}

public static Set<Entry<String, Class<?>>> getProxyClassEntries() {
    return REMOTE_EJB_CLASS_MAP.entrySet();
}

public static InitialContext getContext() {
    return RemoteProxyFactory.CTX;
}

public static final class Builder {

    private static final Logger LOGGER = Logger.getLogger(Builder.class.getName());

    /**
     * Create a new proxy that lookup the remote EJB
     * though JNDI.
     * @param remoteEJBClazz the remote class contract
     * @return a new remote EJB proxy
     */
    public static Object createEJBRemoteProxy(final Class<?> remoteEJBClazz) {
        return Proxy.newProxyInstance(remoteEJBClazz.getClassLoader(), new Class[] {
            remoteEJBClazz
        }, new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                Object ejbInstance = null;
                try {
                    // Pull the remote EJB from the JNDI
                    ejbInstance = RemoteProxyFactory.getContext().lookup(remoteEJBClazz.getName());
                } catch (Exception e) {
                    throw new IllegalStateException("Remote EJB not found : " + remoteEJBClazz.getSimpleName(), e);
                }
                // Delegates the call to the remote EJB
                return method.invoke(ejbInstance, args);
            }
        });
    }

    /**
     * Create a bean for given proxy / injection target / type / scope
     * @param proxy the proxy object
     * @param it the injection target
     * @param clazz the proxy type
     * @param targetScope the returned managed bean' scope
     * @return the managed bean handling given proxy
     */
    public static <T extends Object> Bean<T> createBeanForProxy(final T proxy, final InjectionTarget<T> it, final Class<?> clazz, final Class<? extends Annotation> targetScope) {
        return new Bean<T>() {

            @Override
            public T create(final CreationalContext<T> ctx) {
                return proxy;
            }

            @Override
            public void destroy(final T instance, final CreationalContext<T> ctx) {
                it.preDestroy(instance);
                it.dispose(instance);
                ctx.release();
            }

            @Override
            public Class<?> getBeanClass() {
                return clazz;
            }

            @Override
            public Set<InjectionPoint> getInjectionPoints() {
                return it.getInjectionPoints();
            }

            @Override
            public String getName() {
                return clazz.toString();
            }

            @Override
            public Set<Annotation> getQualifiers() {
                Set<Annotation> qualifiers = new HashSet<Annotation>();
                qualifiers.add(new AnnotationLiteral<Default>() {
                    /** Default serial-id. */
                    private static final long serialVersionUID = 1L;
                });
                qualifiers.add(new AnnotationLiteral<Any>() {
                    /** Default serial-id. */
                    private static final long serialVersionUID = 1L;
                });
                return qualifiers;
            }

            @Override
            public Class<? extends Annotation> getScope() {
                return targetScope;
            }

            @Override
            public Set<Class<? extends Annotation>> getStereotypes() {
                return Collections.emptySet();
            }

            @Override
            public Set<Type> getTypes() {
                Set<Type> types = new HashSet<Type>();
                types.add(clazz);
                return types;
            }

            @Override
            public boolean isAlternative() {
                return false;
            }

            @Override
            public boolean isNullable() {
                return false;
            }

        };
    }
}