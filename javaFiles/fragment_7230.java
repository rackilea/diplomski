public class SimpleTest {

    private static int a;
    private static int b = printAAndBReturning2("initializer");

    static {
        printAAndBReturning2("static initializing block");
    }

    public static void main(String[] args) {

        printAAndBReturning2("main");

    }

    public static int printAAndBReturning2(String where) {
        System.out.printf("In %s a is %d and b is %d%n", where, SimpleTest.a, SimpleTest.b);
        return 2;
    }
}