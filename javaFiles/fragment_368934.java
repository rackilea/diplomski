@Path("/players")
public class PlayerResource{
  @GET
  public List<Player> list(){}

  @GET
  @Path("{id}")
  public Player get(@PathParam("id")Long id){}

  @DELETE
  @RolesAllowed("ADMIN")
  @Path("{id}")
  public Player delete(@PathParam("id")Long id){}

  //PUT and POST ommited

}