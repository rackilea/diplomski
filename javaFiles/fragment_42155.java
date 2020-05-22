public class A {

    private int a = 1;
    private int b = 2;
    private int c = 3;
    int d = 4;
    int e = 5;

    public static void main(String[] args) {
        new B().test();
    }

    private static class B extends A {

        private void test() {
            System.out.println(((A) this).a);
        }
    }
}