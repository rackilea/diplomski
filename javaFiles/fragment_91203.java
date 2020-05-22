@POST
@Path("/someSummary/create/all/uri")
@Consumes(MediaType.APPLICATION_XML)
public Response createSumaryFromUrl(@QueryParam("uri") SomeDataList someDataResourceString) {
   //....
}