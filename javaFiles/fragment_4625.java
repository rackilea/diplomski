public class Test {
    static void doIt(Number n) { }
    static void go(Long l) { }
    public static void main(String[] args) {
        int i = 1;
        doIt(i); // OK. i is boxed to Integer, and Number is a supertype of Integer
        go(i); // FAILS: Long is not a supertype of Integer
    }
}