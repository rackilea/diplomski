import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

interface IMap extends Iterable<@KeyFor("this") Object> {
    @Nullable Object get(Object o);
    IMap put(Object key, Object value); // immutable put
    IMap empty();

    default IMap remove(@KeyFor("this") Object key) {
        IMap tmp = empty();

        for (Object k : this) {
            if (!k.equals(key)) {
                tmp.put(k, get(k)); // get(k) is always non-null because of the key iterator
            }
        }

        return tmp;
    }
}

class Map implements IMap {
    java.util.Map<Object, Object> contents = new java.util.HashMap<>();

    public Map() {}

    private Map(java.util.Map<Object, Object> contents) {
        this.contents = contents;
    }

    @Override
    public @Nullable Object get(Object key) {
        return contents.get(key);
    }

    @Override
    public IMap empty() {
        return new Map();
    }

    @Override
    public IMap put(Object key, Object value) {
        java.util.Map<Object, Object> newContents = new java.util.HashMap<>();
        newContents.putAll(contents);
        newContents.put(key, value);
        return new Map(newContents);
    }

    @Override
    @SuppressWarnings("keyfor") // a key for `contents` is a key for this object
    public java.util.Iterator<@KeyFor("this") Object> iterator() {
        return contents.keySet().iterator();
    }
}