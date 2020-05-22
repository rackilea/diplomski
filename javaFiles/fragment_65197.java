class B {
    private int b = 15;
    private static int count = 0;

    B() {
        count++;
    }

    public int getB() {
        return b;
    }

    public static int getCount() {
        return count;
    }
}