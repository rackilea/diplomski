public Manager getManagerImplWithName(String name, Class<? extends Manager> subType) {
    Set<?> managers = managersRef.getSubTypesOf(subType);
    for (Object clazz : managers) {
        Service serviceAnno = ((Class<?>) clazz).getAnnotation(Service.class);
        if (serviceAnno != null && !StringUtils.isEmpty(serviceAnno.name()) && serviceAnno.name().equals(name))
            return (Manager) ((Class<?>) clazz).newInstance();
    }
    return null;
}