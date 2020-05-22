class DebugTest {
    public static final boolean DEBUG = true;
    public static void main(String[] args) {
        if (DEBUG) {
            int a = 10;
            System.out.println("a = " + a);
        }
    }
}