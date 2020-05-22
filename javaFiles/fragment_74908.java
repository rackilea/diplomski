@Path("parent")
class ParentResource {
    @Path("{id}")
    public ChildResource  getChild() {
      return new ChildResource();
    }
}

class ChildResource {
    @GET
    public Response get(@PathParam("id") long id) {}

    @GET
    @Path("something")
    public Response something(@PathParam("id") long id) {}
}