public abstract class BaseService<T, K> {

    private CrudRepository<T, K> repository;

    public BaseService(CrudRepository<T, K> repository){
       this.repository = repository;
    }

    T commonMethod(K key){
        T object = repository.findById(key);
        // other processing...
    }
}