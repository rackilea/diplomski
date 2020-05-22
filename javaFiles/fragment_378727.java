@GET
@Path("/test/")
@Produces(MediaType.APPLICATION_JSON)
public TestAddress test(@Context org.glassfish.grizzly.http.server.Request re) {
    System.out.println(re.getRemoteAddr());
    ...
}