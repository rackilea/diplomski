class Base {
    public Base() {}
    public void foo() {
        System.out.println("I'm the base!");
    }
}

class Child extends Base {
    public Child() {}
    public void foo() {
        System.out.println("I'm the child!");
    }
}