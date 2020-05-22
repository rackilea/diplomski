public class SomeClass
{
    private int _x = 0;
    private int _y = 0;
    private String _something = "";

    public SomeClass addX(int n)
    {
        _x += n;
        return this;
    }

    public SomeClass addY(int n)
    {
        _y += n;
        return this;
    }

    public SomeClass setSomething(String something)
    {
        _something = something;
        return this;
    }

    // And so on, and so on, and so on...
}