@Provider
@Consumes("application/json")
public class CustomJsonReader<T> implements MessageBodyReader<T> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations,MediaType mediaType) {
        return true;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations,
            MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException, WebApplicationException {

        /* Convert the request body (passed in as InputStream) to a String.
         * Here I'm using apache commons IOUtils to convert the input stream
         */
        StringWriter writer = new StringWriter();
        IOUtils.copy(entityStream, writer, "UTF-8");
        String json = writer.toString();

        /* Use JSON parser to unmarshal the JSON to a complex object */
        return new Gson().fromJson(json, genericType);
    }
}