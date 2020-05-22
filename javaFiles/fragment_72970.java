class A {
    public void getA() {
         System.out.println("In A");
    }

    public static void main(String[] args) {
        B b = new B();
        b.getB();
    }

}

class B {
    public void getB() {
        System.out.println("In B");
        A a = new A();
        a.getA();
    }

}