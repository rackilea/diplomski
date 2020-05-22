public abstract class NumberType<T extends Number> {
    protected T value;

    public NumberType(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public abstract String getHexadecimalValue();
}

public class FloatingPointType extends NumberType<Float> {
    public FloatingPointType() {
        super(0f);
    }

    public String getHexadecimalValue() {
        return ValueConversions.toHexadecimal(Float.floatToRawIntBits(value));
    }
}