public class MyClass<T> {
    private HashMap<Key<?>, Val<?>> myMap;
    public Val<T> getValue(Key<T> key) {
       return (Val<T>) myMap.get(key);
    }
}