@SuppressWarnings("unchecked")
static class Lookup2 {

    List<ValueObject<?>> valueObjects = new ArrayList<>();
    List<String> valueNames = new ArrayList<>();

    /* unsafe get */
    ValueObject<?> get(String name) {
        return valueObjects.get(valueNames.indexOf(name));
    }


    /* set using unsafe get */
    public <T> void setUnsafe(String name, T value) {
        /* might add handling of runtime exceptions */
        ((ValueObject<T>)get(name)).setValue(value);
    }

    /* safe get when client knows class */
    <T> ValueObject<T> get(String name, Class<T> clazz) {
        /* might do instanceOf check here to throw custom exception */
        return (ValueObject<T>) valueObjects.get(valueNames.indexOf(name));
    }

    /* set using safe get */
    public <T> void set(String name, T value) {
        /* might add handling of runtime exceptions */
        get(name, (Class<T>) value.getClass()).setValue(value);
    }
}