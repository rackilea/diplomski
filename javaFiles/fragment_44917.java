C c = new C();
A a = new A(c);
B b = new B(c);

...

public class A 
{
    private final C c;

    public A(C c)
    {
        this.c = c;
    }
}