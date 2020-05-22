public class ClassMap {

    private Map<Class<?>, Collection<?>> internalMap 
        = new HashMap<Class<?>, Collection<?>>();

    public <T, TCollection extends Collection<T>> void put(
            Class<T> clazz, 
            TCollection collection) {
        internalMap.put(clazz, collection);
    }

    public <T> Collection<T> get(Class<T> clazz) {
        // Notice the cast, it is important as it will hide
        // the "compiler grumble" you mention in your post
        return (Collection<T>) internalMap.get(clazz);
    }
}