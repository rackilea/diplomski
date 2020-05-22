class Dao<Model extends AbstractModel> {
    private final Class<?> typeArgument;

    public Dao() {
        Type superclass = getClass().getGenericSuperclass(); 
        ParameterizedType parameterized = (ParameterizedType) superclass;
        // with nested generic types, this becomes a little more complicated
        typeArgument = (Class<?>) parameterized.getActualTypeArguments()[0];
    }

    public String getUrl() {
        return typeArgument.getAnnotation(MyPath.class).url();
    }
}