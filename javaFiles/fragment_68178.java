public class MyMap<T>
{
    interface FunctionObject<X> {}

    private Map<Class<? extends T>, FunctionObject<Object>> map = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <E extends T> void put(Class<E> c, FunctionObject<? super E> f)
    {
        map.put(c, (FunctionObject<Object>) f);
    }

    public <E extends T> FunctionObject<Object> get(Class<E> c)
    {
        return map.get(c);
    }

    public static void Main(String[] args)
    {
        MyMap<Number> map = new MyMap<>();

        map.put(Integer.class, new FunctionObject<Integer>() {});
        map.put(Float.class, new FunctionObject<Number>() {});
        map.put(Double.class, new FunctionObject<Object>() {});
    }
}