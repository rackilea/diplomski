@PATH("/hello")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String sayPlainTextHello(final String input) {
  return "{\"result\": \"Hello world\"}";
}