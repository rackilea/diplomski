public static class Ref<T> {
    T value;

    public Ref(T initValue) {
        this.set(initValue);
    }

    public void set(T Value) {
        this.value = Value;
    }

    public T get() {
        return this.value;
    }

    public static Ref<Byte> createByteRef() {
        return new Ref<Byte>((byte)0);
    }

    public static Ref<Byte> createByteRef(byte value) {
        return new Ref<Byte>(value);
    }
}