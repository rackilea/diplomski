@Provider
@Produces("application/json")
public class CustomMessageBodyWriter implements MessageBodyWriter<Object> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(MyBean myBean, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {

        // Deprecated by JAX-RS 2.0
        return 0;
    }

    @Override
    public void writeTo(Object object, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException {

        // Read the entityStream
        // Perform the validation against your schema
        // Write to the object
    }
}