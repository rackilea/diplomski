public class Example {
    private static class Inner {
         private void innerMethod() { ... }
    }

    public void test() {
        Inner inner = ...
        inner.innerMethod():
    }
}