public MyClass<T>
{
    private final Class<T> clazz;

    public MyClass(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    public void myMethod()
    {
        if (clazz == String.class)
        {
           ...
        }
    }
}