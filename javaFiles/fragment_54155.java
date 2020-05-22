@Component("fooList")
class ListFactory<List<Foo>> implements FactoryBean, ApplicationContextAware {

     ApplicationContext context;
     public List<Foo>> getObject() {
           List<Foo> list = new ArrayList();
           list.add(context.getBean("foo");
           list.add(context.getBean("foo");
           return list;
     }

     public void setApplicationContext(ApplicationContext context) {
             this.context = context;
     }

     public boolean isSingleton() {
           return false;
     }
}

@Component
@Scope("prototype")
class FooClient {

    @Inject
    @Named("footList")
    private List<Foo> fooList;

    public void bar() {
        for (Foo foo : fooList) {
            foo.fooMethod();
        }
    }
}