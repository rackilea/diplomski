public class MyRestletApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        TemplateRoute route = router.attach("/test", MyServerResource.class);
        // Default matching mode
        int defaultMatching = route.getMatchingMode();

        return router;
    }
}