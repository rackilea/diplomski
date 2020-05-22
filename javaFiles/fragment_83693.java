class CharFrequency implements {

    private char value;
    private int count;

    public CharFrequency(char v, int c) {
        this.value = v;
        this.count = c;
    }

    @Override
    public String toString() {
        return value + " -> " + count;
    }
}