public class FooFactoryProcessor implements InitializingBean {

    private Foo foo;

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public void afterPropertiesSet() throws Exception {
        Foofactory.setFoo(foo);
    }
}