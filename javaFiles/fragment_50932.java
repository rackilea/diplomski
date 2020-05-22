public class Property<T> {
    public final String name;
    T value;
    private final PropertyChangeSupport support;

    public static <T> Property<T> newInstance(String name, T value, 
                                              PropertyChangeSupport support) {
        return new Property<T>(name, value, support);
    }

    public static <T> Property<T> newInstance(String name, T value) {
        return newInstance(name, value, null);
    }

    public Property(String name, T value, PropertyChangeSupport support) {
        this.name = name;
        this.value = value;
        this.support = support;
    }

    public T getValue() { return value; }

    public void setValue(T value) {
        T old = this.value;
        this.value = value;
        if(support != null)
            support.firePropertyChange(name, old, this.value);
    }

    public String toString() { return value.toString(); }
}