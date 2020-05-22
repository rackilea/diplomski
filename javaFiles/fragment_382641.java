public <T> void put(MyClassA<T> key, MyClass<B> value) {
    // Maybe check at runtime if the constraint is not validated?
    map.put(key, value);
}

public <T> MyClassB<T> get(MyClassA<T> key) {
    // This will produce an unchecked warning.
    return (T) map.get(key);
}