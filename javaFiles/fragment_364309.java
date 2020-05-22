@POST
@Path("/post")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response createPost(@FormParam("type") String type,  @FormParam("content") String content) { 
    postEJB.createPostUserRest(type, content);
    URI userURI = uriInfo.getAbsolutePathBuilder().build();
    return Response.created(userURI).build();
}