class MyPair {
    private int a;
    private int b;

    public MyPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return String.format("a = %d, b = %d", a, b);
    }

    public void swap() {
        int t = a;
        a = b;
        b = t;
    }
}