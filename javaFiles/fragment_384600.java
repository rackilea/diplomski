public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(MyService.class).to(MyService.class);
    }
}