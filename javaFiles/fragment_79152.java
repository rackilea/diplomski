final DoubleDispatch<Root,Void> dd = new DoubleDispatch<>();

dd.register(X.class, x->
{
    do something with x; its compile time type is X
    return null;
});
dd.register(Y.class, y->
{
    do something with y; its compile time type is Y
    return null;
});
// etc

...
dd.invoke( something );



// ----

public class DoubleDispatch<T, R>
{
    public R invoke(T obj){...}

    public <C extends T> void register(Class<C> type, Function<C,R> func){...}
}