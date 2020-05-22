private static <T> T findServiceProvider(final Class<T> type)
        throws DatatypeConfigurationException{
    try {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {
            public T run() {
                final ServiceLoader<T> serviceLoader = ServiceLoader.load(type);
                final Iterator<T> iterator = serviceLoader.iterator();
                if (iterator.hasNext()) {
                    return iterator.next();
                } else {
                    return null;
                }
            }
        });
    } catch(ServiceConfigurationError e) {
        final DatatypeConfigurationException error =
                new DatatypeConfigurationException(
                    "Provider for " + type + " cannot be found", e);
        throw error;
    }
}