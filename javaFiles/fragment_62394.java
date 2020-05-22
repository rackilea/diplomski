@Post
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public Response myresource(@Context HttpServletRequest request, String postedBody){
   MyObjectClass myObject = new MyObjectClass();
   // ... set myObject properties ...
   return Response.status(200).entity(myObject).build();
}