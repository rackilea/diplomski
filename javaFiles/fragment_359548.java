public class RepeatingListFactoryBean implements FactoryBean<Object> {

    private final Object item;
    private final int count;

    public RepeatingListFactoryBean(Object item, int count) {
        this.item = item;
        this.count = count;
    }

    @Override
    public Object getObject() throws Exception
    {
        final ArrayList<Object> list = new ArrayList<Object>(count);
        for(int i = 0; i < count; ++i)
            list.add(item);
        return list;
    }

    @Override
    public Class<?> getObjectType() {
        return item.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}