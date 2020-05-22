class GenericEntity<T extends Serializable>{
    protected T id;
    public T getId(){ return id;};
}

// THESE ARE UNNECESSARY as far as I can tell
class A extends GenericEntity<Integer>{ }
class B extends GenericEntity<Long>{ }

// where U matches the generic type of GenericEntity<?>
interface IService<T extends GenericEntity<?>, U extends Serializable>{ }

class AService extends IService<A, Integer>{ }
class BService extends IService<B, Long>{ }