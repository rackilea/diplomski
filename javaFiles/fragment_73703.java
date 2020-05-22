@POST
@Path("PostUserData/{userId}")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public final Response postUserData(@PathParam("userId") String userId, 
        String input, HttpSession session){

    // Your method here
    return Response.created(null).build();
}