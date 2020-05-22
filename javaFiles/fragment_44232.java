package jetty.proxy;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.proxy.AsyncProxyServlet;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class MyProxyServlet extends AsyncProxyServlet
{
    @Override
    protected HttpClient newHttpClient()
    {
        SslContextFactory ssl = new SslContextFactory();
        ssl.setTrustAll(true); // configure ssl (example, not required)
        return new HttpClient(ssl);
    }
}