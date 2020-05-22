public interface ValueObject<T> {

    T getValue();

    void setValue(T value);

}