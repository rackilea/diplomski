public class MyClass {

     private Foo foo;
     public MyClass(Foo foo){
        this.foo = foo;
     }
     public void method1() {
          ... 
          String str = foo.method3()
          ...
     }
     public int method2() {...}
}
public class Foo {
     public String method3() {...}
}