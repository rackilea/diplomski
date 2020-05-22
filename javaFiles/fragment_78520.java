public class PropertyKey<T> {
    private final Class<T> clazz;
    private final String name;

    public PropertyKey(Class<T> valueType, String name) {
        this.clazz = valueType;
        this.name = name;
    }

    public boolean checkType(Object value) {
        if (null == value) {
            return true;
        }
        return this.clazz.isAssignableFrom(value.getClass());
    }

    ... rest of the class

}