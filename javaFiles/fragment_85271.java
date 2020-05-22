@Provider
@Produces(MediaType.APPLICATION_JSON)
public class YourWriter implements MessageBodyWriter<Something> {

    @Context UriInfo uriInfo;

    ...
    @Override
    public void writeTo(Something t, Class<?> type, Type type1, Annotation[] antns, 
            MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) 
            throws IOException, WebApplicationException {

        String filter = uriInfo.getQueryParameters().getFirst("filter");
    } 
}