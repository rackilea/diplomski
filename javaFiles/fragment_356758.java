public interface CrudRepository<T, ID extends Serializable>
extends Repository<T, ID> {
                                                                                                                   (1)
<S extends T> S save(S entity);
                                                                                                                   (2)
T findOne(ID primaryKey);
                                                                                                                   (3)
Iterable<T> findAll();

Long count();
                                                                                                                   (4)
void delete(T entity);
                                                                                                                   (5)
boolean exists(ID primaryKey);
                                                                                                                   (6)
// … more functionality omitted.
}