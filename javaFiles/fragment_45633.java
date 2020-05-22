@Override
public Restlet createInboundRoot() {
    Router router = new CustomRouter(getContext());

    router.attach("/test", TokenedResource.class);
    router.attach("/test", NonTokenResource.class);

    return router;
}