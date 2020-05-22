public class Test {
    static void doIt(Long l) { }
    public static void main(String[] args) {
        int i = 1;
        doIt(i); // FAILS. Cannot widen int to long and then box to Long
    }
}