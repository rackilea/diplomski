public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(RequestIdContainerFilter.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(MyWebTargetFactory.class).to(WebTarget.class);
            }
        }
    }
}