public class Foo
{
    public interface Bar
    {
        void doSomething();
    }

    private Bar bar;
    private int counter = 0;

    public Foo( Bar bar )
    {
        this.bar = bar;
    }

    public void loop()
    {
        while ( true )
        {
            counter++;
            bar.doSomething();
        }
    }

    public int getCounter()
    {
        return counter;
    }
}