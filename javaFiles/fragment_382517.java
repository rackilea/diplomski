public interface ISetting<T> {
    T getDefault();
    T value();
    void set(T value);
    String getName();

    // Former default methods:
    String getValueName();
    boolean isHidden();
    boolean isDefault();
    // etc.
}