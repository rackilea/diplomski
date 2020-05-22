public class Test {
    static void doIt(Integer i) { }
    public static void main(String[] args) {
        int i = 1;
        doIt(i); // OK: int i is boxed to Integer
    }
}