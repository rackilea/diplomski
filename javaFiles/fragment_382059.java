public static void main(String[] args) {
    A a = new A(); //prints Original private method
    a.m2(); //prints Some other method

    new MockUp<A>() {

        @Mock
        public void m() {
            System.out.println("New private method");
        }
    };

    A b = new A(); //prints New private method
    b.m2(); //prints Some other method
}

static class A {

    public A() {
        m();
    }

    private void m() {
        System.out.println("Original private method");
    }

    public void m2() {
        System.out.println("Some other method");
    }
}