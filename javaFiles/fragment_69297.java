@Component
public MyBean implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(final BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void myMethod() {
        //I can now use beanFactory here
    }
}