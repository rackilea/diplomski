WebServiceMessageSender sender = new HttpComponentsMessageSender(HttpClients.custom()
            .addInterceptorFirst(new RemoveSoapHeadersInterceptor()).setSSLSocketFactory(factory));
wsTemplate.setMessageSender(sender);        


// copy & paste from HttpComponentsMessageSender:
/**
 * HttpClient {@link org.apache.http.HttpRequestInterceptor} implementation that removes {@code Content-Length} and
 * {@code Transfer-Encoding} headers from the request. Necessary, because SAAJ and other SOAP implementations set
 * these headers themselves, and HttpClient throws an exception if they have been set.
 */
public static class RemoveSoapHeadersInterceptor implements HttpRequestInterceptor {



    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        if (request instanceof HttpEntityEnclosingRequest) {
            if (request.containsHeader(HTTP.TRANSFER_ENCODING)) {
                request.removeHeaders(HTTP.TRANSFER_ENCODING);
            }
            if (request.containsHeader(HTTP.CONTENT_LEN)) {
                request.removeHeaders(HTTP.CONTENT_LEN);
            }
        }
    }
}