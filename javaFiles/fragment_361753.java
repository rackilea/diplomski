public class SignServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SignService.class).toProvider(SignServiceProvider.class).asEagerSingleton();
    }
}