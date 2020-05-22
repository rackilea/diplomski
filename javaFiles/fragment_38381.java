final class Child1 extends Father {
    Child1() { /*...*/ }

    public static boolean predicate() { return true; }

    @Override
    public void method() {
        System.out.println("Child1");
    }
}