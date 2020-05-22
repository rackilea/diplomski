class SpyStrategy extends DefaultRedirectStrategy {
    public final Deque<URI> history = new LinkedList<>();

    public SpyStrategy(URI uri) {
        history.push(uri);
    }

    @Override
    public HttpUriRequest getRedirect(
            HttpRequest request,
            HttpResponse response,
            HttpContext context) throws ProtocolException {
        HttpUriRequest redirect = super.getRedirect(request, response, context);
        history.push(redirect.getURI());
        return redirect;
    }
}