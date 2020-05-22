public class DynamicProxyRoutePlanner implements HttpRoutePlanner {

    private DefaultProxyRoutePlanner defaultProxyRoutePlanner = null;

    public DynamicProxyRoutePlanner(HttpHost host){
        defaultProxyRoutePlanner = new DefaultProxyRoutePlanner(host);
    }

    public void setProxy(HttpHost host){
        defaultProxyRoutePlanner = new DefaultProxyRoutePlanner(host);
    }

    public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) {
        return defaultProxyRoutePlanner.determineRoute(target,request,context); 
    }
}