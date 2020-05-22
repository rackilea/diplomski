private Object newInstance(Object instance, Class<?> clazz) throws IllegalAccessException, InvocationTargetException, NamingException {
    if (!ignoreAnnotations) {
        Map<String, String> injections = injectionMap.get(clazz.getName());
        processAnnotations(instance, injections);
        postConstruct(instance, clazz);
    }
    return instance;
}