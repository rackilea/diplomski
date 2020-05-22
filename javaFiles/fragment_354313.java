public interface Entity<K extends Serializable> {

    K getId();

}

public interface Dao<K extends Serializable, E extends Entity<K>> {

    E create(E entity);

    E update(E entity);

    E delete(E entity);

    E get(K id);

    List<E> getAll();

}