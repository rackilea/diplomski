@Path("/resource")
class MyResource {

  // one way to get HttpServletResponse
  @Context
  private HttpServletResponse anotherServletResponse;

  // another way
  Response myMethod(@Context HttpServletResponse servletResponse) {
      // ... code
  }
}