@Override
protected HttpContext createHttpContext() {
    HttpContext context = new BasicHttpContext();
    context.setAttribute(
        ClientContext.SCHEME_REGISTRY, 
        getConnectionManager().getSchemeRegistry());
    context.setAttribute(
        ClientContext.AUTHSCHEME_REGISTRY, 
        getAuthSchemes());
    context.setAttribute(
        ClientContext.COOKIESPEC_REGISTRY, 
        getCookieSpecs());
    context.setAttribute(
        ClientContext.COOKIE_STORE, 
        getCookieStore());
    context.setAttribute(
        ClientContext.CREDS_PROVIDER, 
        getCredentialsProvider());
    return context;
}