public static class ByteRef extends Ref<Byte> {
    public ByteRef() {
        super((byte)0);
    }

    public ByteRef(byte value) {
        super(value);
    }

    // I'm not sure, if I like this one :-)
    public void set(int value) {
        super.set((byte)value);
    }
}