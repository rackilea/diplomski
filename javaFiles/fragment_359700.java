@GET 
@Path("/living")
@Produces(MediaType.APPLICATION_JSON)
public Response getLivingPets(){
    return Response.ok().entity(gson.toJson(pf.getLivingPets().stream().map(Dto::new).collect(Collectors.toList()))).build();
}