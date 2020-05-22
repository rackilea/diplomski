public class B extends A {

    public static void main(String[] args) {
        new B().bar();
    }

    void bar() {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                B.super.foo(); // this calls A.foo()
            }

        };
        r.run();
    }

    @Override
    void foo() {
        System.out.println("Bad");
    }
}