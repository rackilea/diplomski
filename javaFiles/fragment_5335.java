@GET
@Path("/")
public Response getAll(){
    List<Role> roleList = new ArrayList<Role>();
    roleList = Role.getAll();
    String json = new Gson().toJson(roleList);
    return Response.status(200).entity(json).build();
}