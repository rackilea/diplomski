public class Wrapper<T extends Object>
{
    private final T value;

    public Wrapper()
    {
        value = (T) new Object();
    }

    public T getValue()
    {
        return value;
    }
}