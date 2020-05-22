public class MyMap extends HashMap<String, Object> {
    ...
    // constructors
    ...
    @Override
    public void put(String key, Object value) {
        if (value instanceof ClassA || value instanceof ClassB) {
            super.put(key, value);
        } else {
            throw new IllegalArgumentException("Verbotten!");
        }
    }
    ...
}