final MyResource resource = new MyResource(...);
final AbstractBinder binder = new AbstractBinder() {
    @Override
    public void configure() {
        bind(resource).to(MyResource.class);
    }
};
final MyApp app = new MyApp();
app.register(binder);