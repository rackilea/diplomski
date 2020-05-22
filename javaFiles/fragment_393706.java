public interface I{}
public class A implements I{}
public class B extends A{}
public class C extends B{}
public class D implements I{}
public class E{}

public void method(){

    A a=new A();
    B b=new B();
    C c=new C();

    D d=new D();

    I i=null;

    i=a;i=b;i=c;

    a=b;
    b=c;
    a=c;

    a=(A)i;//a=i does not work, A and I are two different types

    i=d;
    a=(A)i;//ClassCastException at runtime, D is not an A

    E e=new E();
    //a=(A)e; - this generates a compile time error

}//method closing