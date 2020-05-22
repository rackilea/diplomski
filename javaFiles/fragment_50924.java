@GET
@Path("foo")
public Response getFoos(@QueryParam("sort") 
                        @Pattern(regexp = "ASC|DESC") String sortDirection) {
    ...
}