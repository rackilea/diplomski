import org.apache.commons.httpclient.HttpClient;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClientExecutor;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
HttpClient httpClient = new HttpClient();
ApacheHttpClientExecutor executor = new ApacheHttpClientExecutor(httpClient) {
    @Override
    public ClientResponse execute(ClientRequest request) throws Exception {
        request.header("X-My-Header", "value");
        return super.execute(request);
    }           
};

SimpleClient client = ProxyFactory.create(SimpleClient.class, "http://localhost:8081", executor);
client.putBasic("hello world");