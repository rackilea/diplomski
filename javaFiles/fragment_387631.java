public abstract class A<T> {

    private Type type;

    public A() {
        Type superclass = getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }

    public <K> void m(A<K> target) {
            System.out.println( type.equals( target.type ) );
    }
}