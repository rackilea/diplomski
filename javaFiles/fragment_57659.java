public interface Foo{
    void doSomeThing();
}

public class SomeFoo implements Foo{
    public void doSomeThing(){
       System.out.println("foo");
    }
}

public class OtherFoo implements Foo{
    public void doSomeThing(){
       System.out.println("bar");
    }
}