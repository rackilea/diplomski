@PUT
@Path("/foo/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response putAFoo(@PathParam("id") int theId, Foo theFoo) {
  // Save theFoo which has theId or do what you want with it.
  if (fooWasCreated) {
    return Response.created("/foo/" + theId).build();
  } else {
    return Response.ok().build();
  }
}