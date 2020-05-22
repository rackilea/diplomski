class A {
    public void foo() {
        System.out.println("A#foo()");
    }

    public void bar() {
        System.out.println("A#bar()");
        qux();
    }

    private void qux() {
        System.out.println("A#qux()");
    }
}

class B extends A {
    public void foo() {
        System.out.println("B#foo()");
    }

    private void qux() {
        System.out.println("B#qux()");
    }
}