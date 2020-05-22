abstract class Bar {
    protected  int  a = 0;
    public  void increaseA() {
        a++;
    }
    public void printA() {
        System.out.println(a);
    }


}

interface FooBar {
    default void printClassName(){
        System.out.println("FooBar");
    }
}

class Foo extends Bar implements FooBar {
    @Override
    public void printClassName() {
        FooBar.super.printClassName();
        System.out.println("Foo");
    }
}



public class Q4 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        FooBar fooBar = foo;
        foo.printClassName();
        Bar bar = foo;
        bar.increaseA();
        bar.printA();
    }
}