public interface HasOwnKey<K> {
    public K getKey();
}

public class MyMap<K, V extends HasOwnKey<K>> {
{
    private Map<K,V> map = new HashMap<>();
    public V put(V value) {
    {
        return this.map.put(value.getKey(),value);
    }
    public V get(K key) {
        return this.map.get(key)
    }
    ... etc
}

public class MyClass extends HasOwnKey<String> {
    ...
    @Override String getKey() { return this.key; }
}

MyMap<String, MyClass> myMap = new MyMap<>();
MyClass obj = new MyClass();
obj.setKey("abc");
myMap.put(obj);