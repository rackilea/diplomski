@GET 
@Path("/living")
@Produces(MediaType.APPLICATION_JSON)
public Response getLivingPets(){
    Gson gson = new GsonBuilder().registerTypeAdapter(Owner.class, new PetAdapter()).create();
    return Response.ok().entity(gson.toJson(pf.getLivingPets())).build();
}