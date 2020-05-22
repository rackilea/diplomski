public abstract class ElsAbstractCrudClass<T> {
    final Class<T> entityClass;

    public ElsAbstractCrudClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}