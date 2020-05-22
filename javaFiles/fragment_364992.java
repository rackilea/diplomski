public class ParseValue<T> {
    public String value;
    public final Class<T> classType;

    public T parseValue() {
        Object result;
        if (classType == String.class) {
            result = value;
        } else if (classType == Double.class) {
            result = Double.valueOf(value);
        } else {
            throw new RuntimeException("unknown value type");
        }
        return classType.cast(result);
    }
}