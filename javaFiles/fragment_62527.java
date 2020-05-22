public class Parent {
    public static void foo() { ... }
}

public class Child {
    public static void foo() { ... }
    public static void main(String[] args) {
        foo();  // calls local override
        Parent.foo(); // calls original version.
}