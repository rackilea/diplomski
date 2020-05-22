class NormalArray implements Array {
    private long[] data;

    public NormalArray(int size) {
        data = new long[size];
    }

    @Override
    public long get(int i) {
        return data[i];
    }

    @Override
    public void set(int i, long v) {
        data[i] = v;
    }
}