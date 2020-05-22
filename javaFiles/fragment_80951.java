final Set<HttpHost> sitesToBlock = new HashSet<HttpHost>();
sitesToBlock.add(new HttpHost("example.com", 80));

DefaultRoutePlanner routePlanner = new DefaultRoutePlanner(DefaultSchemePortResolver.INSTANCE) {

    @Override
    public HttpRoute determineRoute(
            final HttpHost host, final HttpRequest request, final HttpContext context) throws HttpException {

        final HttpRoute route = super.determineRoute(host, request, context);
        if (sitesToBlock.contains(route.getTargetHost())) {
            throw new HttpException("Connection to " + host + " is blocked");
        }
        return route;
    }
};

CloseableHttpClient client = HttpClients.custom()
        .setRoutePlanner(routePlanner)
        .build();

}