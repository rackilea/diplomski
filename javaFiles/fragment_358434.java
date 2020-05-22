class bar<V>
{
    private Class<V> baz;

    private V qux;

    public bar(Class<V> foo)
    {
        baz = foo;
    }

    void create()
    {
        qux = baz.newInstance();
    }
}

bar<Integer> quxx = new bar<Integer>(Integer.class);