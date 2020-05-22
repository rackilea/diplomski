public class RestletApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/test", MyServerResource.class);
        MyFilter filter = new MyFilter(getContext(), router);
        return filter;
    }
}