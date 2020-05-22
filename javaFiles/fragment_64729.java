public class SomeClass
{
    private int _x = 0;
    private int _y = 0;
    private String _something = "";

    public SomeClass(int x, int y, String something)
    {
        _x = x;
        _y = y;
        _something = something;
    }

    public SomeClass addX(int n)
    {
        return new SomeClass(_x + n, _y, _something);
    }

    public SomeClass addY(int n)
    {
        return new SomeClass(_x, _y + n, _something);
    }

    public SomeClass setSomething(String something)
    {
        return new SomeClass(_x, _y, something);
    }

    // And so on, and so on, and so on...
}