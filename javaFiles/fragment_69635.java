class A {
    public void aMethod() {
        if (this instanceof B) {
            System.out.println("I'm a B!");
        }
    }
}

public class B extends A {

    public static void main(String[] args) {
        B b = new B();
        b.aMethod();
    }
}