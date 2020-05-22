class A {
    // if any variable then make them static
    static {
        // some time-consuming code;
    }

    public static void methodInA() {
        // some method in A;
    }
}

class B {
    public B() {
        for (int i = 0; i < 10000; i++)
            methodInB();
    }

    public void methodInB() {
        A.methodInA(); // directly call static method
    }
}