public class State {
    private static HttpContext httpContext;
    public static HttpContext getHttpContext() {
        if(httpContext == null) {
            httpContext = new BasicHttpContext();
            CookieStore cookieStore = getCookieStore();
            httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
        }
        return httpContext;
    }
    private static CookieStore cookieStore;
    public static CookieStore getCookieStore() {
        if(cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        return cookieStore;
    }
}