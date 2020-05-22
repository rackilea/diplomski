public class A {

    private int a;

    private abstract class B {
        public abstract void printA();
    }

    public B makeB() {
        return new B() {
            @Override
            public void printA() {
                System.out.println(A.this.a);
            }
        };
    }
}