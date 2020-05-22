public class PreferenceImpl implements Preference<T> {
    private final String name;
    private final T value;

    public PreferenceImpl(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return this.name; }
    public T getValue() { return this.value; }
}