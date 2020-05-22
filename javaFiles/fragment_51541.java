@Context
private UriInfo urinfo;

private String queryparam;

@GET
@Produces(value = MediaType.APPLICATION_JSON)
public Response bla(){

    MultivaluedMap<String, String> params = urinfo.getQueryParameters(true);

    queryparam = params.containsKey("yourparam") ? 
                            params.get("yourparam").get(0) 
                            : "not in request";

    return Response.ok(queryparam).build();
}