private static class A {
    private A() {
        throw new Error();
    }
}
public static void main(String... ignored) {
    new A();
}