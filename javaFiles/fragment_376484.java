public class InjectApplication extends ResourceConfig {

    public InjectApplication() {
        ...
        register(new AbstractBinder(){
            @Override
            protected void configure() {
                bindFactory(MyObjectFactory.class)
                        .to(MyObject.class)
                        .in(RequestScoped.class);
            } 
        });
    }
}