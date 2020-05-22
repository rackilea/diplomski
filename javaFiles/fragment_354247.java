@POST 
@Path("/json/saveuser")
@Consumes("application/json")
public Response saveUserJSON(User user) {
    if (save(user)) {
        return Response.status(HttpStatus.SC_OK).build();
    }
        return Response.status(HttpStatus.SC_BAD_REQUEST).build();
}