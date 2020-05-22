public class MyTypeImmutable<T> implements MyType<T>
{
    private final T something;

    public MyTypeImmutable(T something)
    {
        this.something = something;
    }

    @Override
    public T getSomething()
    {
        return something;
    }
}