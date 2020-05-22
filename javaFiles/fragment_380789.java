public static <T> Supplier<T> constructorLookup(Class<?> rawtype) {
    try {
        Constructor<?> cons = rawtype.getConstructor();

        return new Supplier<T>() {
            @SuppressWarnings("unchecked")
            @Override
            public T get() {
                try {
                    return (T) cons.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    throw new IllegalStateException(e);
                }
            }               
        };

    } catch (NoSuchMethodException | SecurityException e) {
        throw new IllegalArgumentException(e);
    }       
}