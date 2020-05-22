class NoOpArray implements Array {
    @Override
    public long get(int i) {
        return 0;
    }
    @Override
    public void set(int i, long v) {
    }
}