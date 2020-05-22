@GET
@Path("/create")
@Produces(MediaType.TEXT_PLAIN)
public String createFromGet(
        @QueryParam("meg") String meg,
        @QueryParam("name") String name) {
    ...
    return theString;
}