public static void main(String[] args)
{
    BarIf bar = newRandomBarImpl();
    performTheAction(bar.getClass(), bar);
}
static <T extends BarIf> void performTheAction(Class<T> cl, BarIf obj) {
    FooIf<T> foo=newFooBar(cl);
    foo.doSomething(cl.cast(obj));
}
static <S extends BarIf> FooIf<S> newFooBar(Class<S> barClass){}
static BarIf newRandomBarImpl(){}

interface FooIf<T extends BarIf> {
    public void doSomething(T t);
}
interface BarIf{}