public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UserService.class).to(UserService.class).in(Singleton.class);
    }
}