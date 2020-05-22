public class Module extends AbstractModule {  
    @Override  
    protected void configure() {  
        bind(MyClass4AppLifecycle.class).asEagerSingleton();
    }  
}