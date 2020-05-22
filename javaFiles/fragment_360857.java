import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;

public Client {

    private final URI fServerURI;
    private final ApacheHttpClient fClient;
    private final MediaType fMediaType= MediaType.APPLICATION_XML_TYPE;

    public Client() {
            final String apiEndpoint= "...";
            final DefaultApacheHttpClientConfig clientConfig;
            fServerURI= UriBuilder.fromUri(apiEndpoint).build();
            clientConfig= new DefaultApacheHttpClientConfig();
            clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, true);
            fClient= ApacheHttpClient.create(clientConfig);
    }

    private <T> T call(WebResource resource, RequestType requestType, Object requestEntity, GenericType<T> acceptType, String taskMessage) {
            return acceptCall(resource, requestType, acceptType, requestEntity);
    }

    private <T> T acceptCall(WebResource resource, RequestType requestType, GenericType<T> acceptType, Object requestEntity) {
           switch (requestType) {
           case POST:
                return resource.accept(fMediaType).post(acceptType, requestEntity);
           case PUT:
                return resource.accept(fMediaType).put(acceptType, requestEntity);
           case DELETE:
                resource.accept(fMediaType).delete();
                return null;
           default:
                return resource.accept(fMediaType).get(acceptType);
    }

    public MyArrayList sendArrayList(MyArrayList list) {
           WebResource resource= createResource();
           resource= resource.path("webservice").path("sendarraylist");
           resource= resource.queryParam("arraylist", list);
           return call(resource, RequestType.POST, null, new GenericType<MyArrayList>() {
    }, "Send my array list");
    }

    public static void main(String ... args) {
           Client c= new Client();
           MyArrayList result= c.sendArrayList(new MyArrayList(/*whatevs goes inside*/));
    }
 }