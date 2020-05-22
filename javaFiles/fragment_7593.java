private static void addAnnotatedEntityClasses(Configuration configuration) {
    Reflections reflections = new Reflections("com.mypackage");
    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);

    logger.debug("Adding Hibernate Mapping for: ");
    for (final Class<?> clazz : classes) {
        logger.debug(clazz.getName());
        configuration.addAnnotatedClass(clazz);
    }
}