public class MyObject<T>
{
    private T _t;
    private Class<T> type;

    public MyObject( Class<T> type, T t)
    {
        _t = t;
        this.type = type;
    }

    //...

    public T get()
    {
        return _t;
    }

    public Class<T> getType() { return type; }
}