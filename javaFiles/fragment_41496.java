@GET
@Path("/{groupid}") 
@Produces(MediaType.TEXT_HTML)
public String listGroups(@PathParam("groupid") long groupid) {
    // logic from MyResource#getGroupByID

    StringBuilder htmlBuilder = new StringBuilder();
    htmlBuilder.append("<html>");

    ...
}