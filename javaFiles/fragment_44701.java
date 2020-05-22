@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class JacksonWriter implements MessageBodyWriter<Object> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) {
        try {
            MAPPER.writeValue(entityStream, value);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}