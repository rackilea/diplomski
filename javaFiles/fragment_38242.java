public class Test {

    static void foo(Comparable<?> c) {
        System.out.println(c.getClass());
    }

    public static void main(String args[]) throws Exception {
        foo(10);
    }
}