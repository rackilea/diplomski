class B{
    B(){
        System.out.println("binit");
        f();
    }
    public void f(){
        System.out.println("B ctor");
    }
}

class A extends B{
    A(){
        System.out.println("ainit");
        f();
    }

    @Override
    public void f(){
        System.out.println("A ctor");
    }

    public static void main(String[] args) {
        System.out.println(1);
        A a = new A();
        System.out.println(2);
        a.f();
        System.out.println(3);
        B b = new B();
        System.out.println(4);
        b.f();
    }
}