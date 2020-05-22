public <T> Class<? extends T> findEntityClassForEntityInterface(
    SessionFactory sessionFactory, 
    Class<T> entityInterface
) {
    for (ClassMetadata metadata : sessionFactory.getAllClassMetadata().values()) {
        Class entityClass = metadata.getMappedClass(EntityMode.POJO);
        if (entityInterface.isAssignableFrom(entityClass)) {
            return entityClass;
        }
    }
    return null;
}