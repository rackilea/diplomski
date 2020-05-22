public class ZippedClientHttpRequest extends WrapperClientHttpRequest
{
    private GZIPOutputStream zip;

    public ZippedClientHttpRequest(ClientHttpRequest delegate) {
        super(delegate);
        delegate.getHeaders().add("Content-Encoding", "gzip");
        // here or in getBody could add content-length to avoid chunking
        // but is it available ? 
        // delegate.getHeaders().add("Content-Length", "39");

    }

    @Override
    public OutputStream getBody() throws IOException {
        final OutputStream body = super.getBody();
        zip = new GZIPOutputStream(body);
        return zip;
    }

    @Override
    public ClientHttpResponse execute() throws IOException {
        if (zip!=null) zip.close();
        return super.execute();
    }

}