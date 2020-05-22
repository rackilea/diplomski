public interface MyType<T>
{
    T getSomething();
}

public class MyTypeImpl<T> implements MyType<T>
{
    private T something;

    public MyTypeImpl(T something)
    {
        this.something = something;
    }

    @Override
    public T getSomething()
    {
        return something;
    }

    public void setSomething(T something)
    {
        this.something = something;
    }
}

public interface MyExtendedType<T> extends MyType<T>
{
    T getMore();
}

public class MyExtendedTypeImpl<T>
        extends MyTypeImpl<T>
        implements MyExtendedType<T>
{
    private T more;

    public MyExtendedTypeImpl(T something, T more)
    {
        super(something);

        this.more = more;
    }

    @Override
    public T getMore()
    {
        return more;
    }

    public void setMore(T more)
    {
        this.more = more;
    }
}