public abstract class GenericDao<E, ID extends Serializable> {
    ...
    // Implement common operations that are relevant to all entities here:
    public E findById(ID id) { ... }
    public void save(E entity) { ... }
    // etc
    ...
}