@Path("/")
class TestClass {
    @GET
    @Path("text")
    @Produces("text/plain")
    String getText() {
        return "String value";
    }
}