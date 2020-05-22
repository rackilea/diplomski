public interface EntitiesDao<T> 
{
    void add(T entity);
    List<T> getList();
    void update(T entity);
    T findById(Long entityId);
    void delete(Long entityId);
}