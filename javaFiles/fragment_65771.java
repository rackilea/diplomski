import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.vnomicscorp.firebase.sdk.FirebaseSdk;
import com.vnomicscorp.firebase.sdk.FirebaseSdkException;

public class FirebaseSdkJersey {

    private static final String DEFAULT_AUTH_PARAM_NAME = "auth";
    private static final String DEFAULT_PATH_FORMAT = "%s.json";

    private final String credentials;
    private final String url;
    private final Client client;

    private String authParamName = DEFAULT_AUTH_PARAM_NAME;
    private String pathFormat = DEFAULT_PATH_FORMAT;

    public FirebaseSdkJersey(String url, String credentials, Client client) {
        this.url = url;
        this.credentials = credentials;
        this.client = client;
    }

    public void setValue(String path, String value) throws Exception {
        client.resource(url).path(String.format(pathFormat, path))
                    .queryParam(authParamName, credentials)
                    .type(MediaType.APPLICATION_JSON).entity(value)
                    .put(String.class);
    }

    public String getValue(String path) throws Exception {
        return client.resource(url).path(String.format(pathFormat, path))
                .queryParam(authParamName, credentials).get(String.class);
    }

    public void deleteValue(String path) throws Exception {
        client.resource(url).path(String.format(pathFormat, path))
                .queryParam(authParamName, credentials).delete(String.class);
    }
}