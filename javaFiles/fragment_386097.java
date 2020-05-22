private List<IRepository<? extends IEntity>> repositories;

@SuppressWarnings("unchecked")
public <E extends IEntity> IRepository<E> getByType(Class<E> entityClass) {
    for (IRepository<?> repository : repositories) {
        if (repository.getEntityClass().equals(entityClass)) {
            return (IRepository<E>) repository;
        }
    }
    throw new IllegalArgumentException(
            "No repository for entity class " + entityClass.getName());
}