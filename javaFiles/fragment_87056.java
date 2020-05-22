public class A {
    B b;
    int number = 5;

    public A() {
        b = new B(this);
    }

    class B {
        public B() {
            System.out.println(number); //Has access because it must be constructed within an A instance
        }
    }
}