class IntArray {
    private int[] array;
    public IntArray(int[] array) {
        this.array = array;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.array);
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IntArray && Arrays.equals(this.array, ((IntArray) obj).array));
    }
    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}