public interface GenericDAO <T, K extends Serializable> {  
    List<T> getAll(Class<T> typeClass);   
    T findByKey(Class<T> typeClass, K id);  
    void update(T object);  
    void remove(T object);  
    void insert(T object);  
}