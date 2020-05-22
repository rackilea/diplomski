private static abstract class MyMap<K, V> extends HashMap<K, V> {
    @Override
    public V get(Object key) {
        V val = super.get(key);
        if (val == null && key instanceof K) {
            put((K)key, val = create());
        }
        return val;
    }

    protected abstract V create();
}


public void initialize() {
    properties = new MyMap<String, Map<String, Map<String, String>>>() {
        @Override
        protected Map<String, Map<String, String>> create() {
            return new MyMap<String, Map<String, String>>() {
                @Override
                protected Map<String, String> create() {
                    return new HashMap<String, String>();
                }
            };
        }
    };

}