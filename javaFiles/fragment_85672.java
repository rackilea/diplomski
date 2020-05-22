public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(GenericExceptionMapper.class);
            }
        });
    }
}