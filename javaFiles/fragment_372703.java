public class CustomDecoder extends GsonDecoder {

    private Map<String, Collection<String>> headers;

    @Override
    public Object decode(Response response, Type type) throws IOException {
        headers = response.headers();
        return super.decode(response, type);
    }

    public Map<String, Collection<String>> getHeaders() {
        return headers;
    }
}