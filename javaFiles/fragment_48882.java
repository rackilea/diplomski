...
public class MyRedirectStrategy extends DefaultRedirectStrategy {
...
    @Override
    public boolean isRedirected(
        final HttpRequest request,
        final HttpResponse response,
        final HttpContext context) throws ProtocolException {
        // check request and return true or false to redirect or not
    ...
    }
}