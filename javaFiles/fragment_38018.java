@POST
@Path("/get_user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response<User> getUser (String id){
    //Logic
    return new Response<User> ("result", "message", user);
}