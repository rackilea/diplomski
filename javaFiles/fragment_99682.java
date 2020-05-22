@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class MyCustomResponseReader extends MOXyJsonProvider {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return genericType.equals(MyCustomClass.class);
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException, WebApplicationException {
        return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }

}