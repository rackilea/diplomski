public class Test {
    static void doIt(long l) { }
    public static void main(String[] args) {
        int i = 1;
        doIt(i); // OK: int i is widened to long
    }
}