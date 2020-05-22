import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.net.URI;
import java.net.URISyntaxException;

public class GzipHttpRequestInterceptor implements HttpRequestInterceptor {

    private final String targetHost;

    public GzipHttpRequestInterceptor(String targetUrl) throws URISyntaxException {
        this.targetHost = getDomainName(targetUrl);
    }

    private String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost() + ":" + uri.getPort();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    @Override
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        final HttpEntityEnclosingRequest entityRequest = (HttpEntityEnclosingRequest) httpRequest;
        final HttpEntity entity = entityRequest.getEntity();
        if (entity != null) {
            final GzipCompressingEntity zippedEntity = new GzipCompressingEntity(entity);
            entityRequest.setEntity(zippedEntity);

            httpRequest.removeHeaders(HTTP.CONTENT_ENCODING);
            httpRequest.addHeader(zippedEntity.getContentEncoding());

            httpRequest.removeHeaders(HTTP.CONTENT_LEN);
            httpRequest.removeHeaders("Accept");

            httpRequest.removeHeaders(HTTP.TRANSFER_ENCODING);
            httpRequest.addHeader(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
            httpRequest.addHeader(HTTP.TARGET_HOST, targetHost);
        }
    }
}