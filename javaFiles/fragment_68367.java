class SerializableInstanceOf<T> implements Serializable {
    public final T instance;

    public SerializableInstanceOf(T instance) {
        Serializable s = (Serializable)instance;
        this.instance = instance;
    }
}