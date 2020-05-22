public class C {
    public B b = new B();
    void method2(){
        b.setname("BBB");
    }
}

public class A {
    public C c = new C();
    public B b =new B();
    void method1(){
        b.setname("AAA");

        System.out.println(b.getname());
    }
}
public class Testcase {
    public static void main(String[] args) {
        A a=new A();
        a.c.b.setname("tralala");

    }
}