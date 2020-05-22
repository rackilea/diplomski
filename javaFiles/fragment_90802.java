public class DefaultMap<K, V> extends TreeMap<K, V> {

    static abstract class Generator<V>{
        abstract V create();
    }

    final Generator<V> generator;


    DefaultMap(Generator<V> generator) {
        this.generator = generator;
    }

    @Override
    public V get(Object key) {
        V val = super.get(key);
        if (val == null) {
            val = generator.create();

            put((K)key, val);
        }

        return val;
    }
}