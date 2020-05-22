public interface FooService()
{
    void foo();
    void bar();
}

public class FooServiceImpl implements FooService
{
    public void foo() { System.out.println("calling foo"); }
    public void bar()
    {
        this.foo(); // just call your own method.
    }
}