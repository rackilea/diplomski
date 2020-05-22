public class ClassMap {

    private Map<Class<?>, Collection<?>> internalMap 
        = new HashMap<Class<?>, Collection<?>>();

    public <T> void put(Class<T> clazz, Collection<T> collection) {
        internalMap.put(clazz, collection);
    }

    public <T> Collection<T> get(Class<T> clazz) {
        return (Collection<T>) internalMap.get(clazz);
    }
}