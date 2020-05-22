@Provider
@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
public class CustomXSSFWorkbookWriter implements MessageBodyWriter {
    //This methode is the most important for you
    @Override
public void writeTo(Object target, Class type, Type genericType,
        Annotation[] annotations, MediaType mediaType,
        MultivaluedMap httpHeaders, OutputStream outputStream)
        throws IOException {