class Example {
    private final Map<Key<?>, Object> m = new HashMap<>();

    <V> Key<V> put(String s, V v) {
        Key<V> k = new Key<>(s, v);
        put(k, v);
        return k;
    }

    <V> void put(Key<V> k, V v) {
        m.put(k, v);
    }

    <V> V get(Key<V> k) {
        Object v = m.get(k);
        return k.c.isInstance(v) ? k.c.cast(v) : null;
    }

    static final class Key<V> {
        private final String k;
        private final Class<? extends V> c;

        @SuppressWarnings("unchecked")
        Key(String k, V v) {
            // this cast will always be safe unless
            // the outside world is doing something fishy
            // like using raw types
            this(k, (Class<? extends V>) v.getClass());
        }

        Key(String k, Class<? extends V> c) {
            this.k = k;
            this.c = c;
        }

        @Override
        public int hashCode() {
            return k.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Key<?>) && ((Key<?>) o).k.equals(k);
        }
    }
}