SerializedWrapper<NoSerializable> property = new SerializedWrapper(() -> new NoSerializable(text));
// call this to use it.
property.get();

/**
 * Makes an unserializable class serializable through lazy initialization.
 */
public class SerializedWrapper<T> implements Serializable {

    private SerializedConstructor<T> constructor;
    private transient T instance;

    /**
     * Creates a serializable wrapper for something.
     */
    public SerializedWrapper(SerializedConstructor<T> constructor) {
        this.constructor = constructor;
    }

    /**
     * Gets or creates an instance of T.
     */
    public T get() {
        if (instance == null){
            instance = constructor.get();
        }
        return instance;
    }

}

/**
 * Dummy interface so we don't have to do (Consumer<T> & Serializable)
 */
public interface SerializedConstructor<T> implements Serializable, Consumer<T> {}