@POST
@Path("logIn")
public Response login(@Context ServletContext context) {
    UriBuilder uriBuilder = UriBuilder.fromUri(URI.create(context.getContextPath()));
    uriBuilder.path(.. <path-to-your-jsp> ..);
    uriBuilder.queryParam("key1", "value1");
    uriBuilder.queryParam("key1", "value2");
    URI uri = uriBuilder.build();

    return Response.seeOther(uri).build();
}