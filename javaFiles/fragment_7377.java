interface Foo
{
    Object getBar();
}

public class Test implements Foo
{
    @Override
    public String getBar()
    {
        return "hi";
    }
}