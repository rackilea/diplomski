public class GenericEntry<KeyType , ValueType> {
    private final KeyType key;
    private ValueType value;

    public MyEntry(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }
}