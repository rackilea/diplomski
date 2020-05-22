public class GZipClientHttpRequestFactory extends AbstractClientHttpRequestFactoryWrapper {

    public GZipClientHttpRequestFactory(ClientHttpRequestFactory requestFactory) {
        super(requestFactory);
    }

    @Override
    protected ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod, ClientHttpRequestFactory requestFactory)
            throws IOException {
        ClientHttpRequest delegate = requestFactory.createRequest(uri, httpMethod);
        return new ZippedClientHttpRequest(delegate);
    }

}