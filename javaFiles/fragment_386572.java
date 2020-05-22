class Parent<T> {

    protected T results;

    Parent(T results) {
        this.results = results;
    }

    ...
}

class Child<K, V> extends Parent<HashMap<K, V>> {

    Child() {
        super(new HashMap<K, V>());
    }

    ...
}