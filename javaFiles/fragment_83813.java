public class StringConverter implements Converter<Object>{


    @Override
    public String fromBody(ResponseBody body) throws IOException {
        return ByteString.read(body.byteStream(), (int) body.contentLength()).utf8();
    }

    @Override
    public RequestBody toBody(Object value) {
        return RequestBody.create(MediaType.parse("text/plain"), value.toString());
    }
}