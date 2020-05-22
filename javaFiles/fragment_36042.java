@GET
@Path("getSearchResults")
@Produces(MediaType.APPLICATION_JSON)
public Response getSearchResults(@HeaderParam("Range") String range) {
    // parse range String
    // perform search
    return Response.ok(responseList.toArray()).header("Content-Range", "items " + startItem + "-" + endItem + "/" + totalItems).build();
}