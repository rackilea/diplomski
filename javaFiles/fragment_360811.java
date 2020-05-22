public class BeanListFactoryBean<T> extends AbstractFactoryBean<Collection<T>> {

    private Class<T> beanType;
    private @Autowired ListableBeanFactory beanFactory;

    @Required
    public void setBeanType(Class<T> beanType) {
        this.beanType = beanType;
    }

    @Override
    protected Collection<T> createInstance() throws Exception {
        return beanFactory.getBeansOfType(beanType).values();
    }

    @Override
    public Class<?> getObjectType() {
        return Collection.class;
    }    
}