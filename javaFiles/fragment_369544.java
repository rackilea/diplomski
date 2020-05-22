public class WrapperClientHttpRequest implements ClientHttpRequest {

    private final ClientHttpRequest delegate;

    protected WrapperClientHttpRequest(ClientHttpRequest delegate) {
        super();
        if (delegate==null)
            throw new IllegalArgumentException("null delegate");
        this.delegate = delegate;
    }

    protected final ClientHttpRequest getDelegate() {
        return delegate;
    }

    @Override
    public OutputStream getBody() throws IOException {
        return delegate.getBody();
    }

    @Override
    public HttpHeaders getHeaders() {
        return delegate.getHeaders();
    }

    @Override
    public URI getURI() {
        return delegate.getURI();
    }

    @Override
    public HttpMethod getMethod() {
        return delegate.getMethod();
    }

    @Override
    public ClientHttpResponse execute() throws IOException {
        return delegate.execute();
    }
}