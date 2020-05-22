public class A {
    private B owner;
    public A(B owner) {this.owner = owner;}

    public void callOwnerDoSomething() {owner.doSomething();}
}

public class B {

    public A theA = new A(this);

    public static void main(String[] args) {
        new B().theA.callOwnerDoSomething(); // prints "Hello"
    }

    public void doSomething() {
        System.out.println("Hello");
    }
}