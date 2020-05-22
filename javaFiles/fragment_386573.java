class Child<K, V> extends Parent<Map<K, V>> {

    Child() {
        super(new HashMap<K, V>());
    }

    ...
}