public class Outer {
    private Inner in;
    public Outer() {
        in = new Inner();
    }
    private class Inner {
        private void test() {
            System.out.println("test");
        }
    }
}