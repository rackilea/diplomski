class GenericEntity<T extends Serializable> {
    protected T id;
    public T getIdFromEntity() { return id; }
}

// 'IService' can/should only know of 'id' as some type that extends 'Serializeable'
// So if something implements 'IService' then everything knows it will have
// a method with the signature 'T getGenericEntity(Serializable id);'
interface IService<T extends GenericEntity<?>> {
    public T getGenericEntity(Serializable id);
}

// 'AService' knows that 'id' will be an 'Integer'
class AService implements IService<GenericEntity<Integer>> {

    Map<Serializable, GenericEntity<Integer>> entityMap = new HashMap<>();

    void someMethod() {
        GenericEntity<Integer> entity = this.getGenericEntity(Integer.valueOf(1));
        Integer i1 = entity.getIdFromEntity();
        // ... do stuff
    }

    // even though 'AService' knows that 'id' will be an 'Integer'
    // the 'IService' interface defines this as taking a 'Serializable'
    // so it must keep that method signature.
    @Override public GenericEntity<Integer> getGenericEntity(Serializable id) {
        return entityMap.get(id);
    }
}

class BService implements IService<GenericEntity<Long>> {
    @Override public GenericEntity<Long> getGenericEntity(Serializable id) { return null; }
    // ... similar to AService ...
}