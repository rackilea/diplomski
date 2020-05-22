public class Outer {

    public Outer() {
        Inner inner = new Inner();
    }

    private class Inner {
        public Inner() {
            Outer outer = new Outer();
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
    }
}