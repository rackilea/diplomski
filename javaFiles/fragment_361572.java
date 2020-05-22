public class TestCompiler {
    public static boolean DEBUG = false;
    private static void debug(Object o) {
        if (DEBUG) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        if (DEBUG) {
            System.out.println(new InnerClass());
        }
        System.out.println("now nested");
        debug(new InnerClass());
    }
    private static final class InnerClass {
        static {
            System.out.println("Innerclass initialized");
        }
    }
}