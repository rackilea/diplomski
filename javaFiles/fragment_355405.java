public class MyObjectFooFactoryBean extends SimpleJdbcDaoSupport implements FactoryBean<ObjectFoo> {
    private String query;

    @Override
    public String getObject() throws Exception {
        return an ObjectFoo here using SimpleJdbSupport (Because I also extended SimpleJdbcDaoSupport)
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectFoo.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}