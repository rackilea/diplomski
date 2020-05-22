@DELETE
@Path("/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Info deleteInfo(
        @HeaderParam("Authorization") String token,
        @PathParam("id") Long id){
}