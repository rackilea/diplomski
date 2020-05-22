public static void initialize(Object proxy) throws HibernateException {
        if ( proxy == null ) {
            return;
        }

        if ( proxy instanceof HibernateProxy ) {
            ( (HibernateProxy) proxy ).getHibernateLazyInitializer().initialize();
        }
        else if ( proxy instanceof PersistentCollection ) {
            ( (PersistentCollection) proxy ).forceInitialization();
        }
        else if ( proxy instanceof PersistentAttributeInterceptable ) {
            final PersistentAttributeInterceptable interceptable = (PersistentAttributeInterceptable) proxy;
            final PersistentAttributeInterceptor interceptor = interceptable.$$_hibernate_getInterceptor();
            if ( interceptor instanceof EnhancementAsProxyLazinessInterceptor ) {
                ( (EnhancementAsProxyLazinessInterceptor) interceptor ).forceInitialize( proxy, null );
            }
        }
    }