public class SupplierFactoryBean<T> extends AbstractFactoryBean<Supplier<T>>{

    private final Class<T> type;
    private final Supplier<T> supplier;

    public SupplierFactoryBean(final Class<T> type){
        this.type = type;
        this.supplier = new Supplier<T>(){
            @Override
            public T get(){
                try{
                    return type.newInstance();
                } catch(final Exception e){
                    throw new IllegalStateException(e);
                }
            }
        };
    }

    @Override
    public Class<?> getObjectType(){ return type; }

    @Override
    protected Supplier<T> createInstance() throws Exception{
        return supplier;
    }
}