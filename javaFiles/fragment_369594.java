public class Parent {
    public void Method2() {
        Parent.this.Method1();
    }

    public void Method1() {
        System.out.println("Parent.Method1()");
    }
}


public class Child extends Parent {
    public void Method1() {
        System.out.println("Child.Method1()");
    }
}