@POST
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/addusers")    
public Response addUsersToGroup(String users) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    List<String> l = mapper.readValue(users, List.class);

    for (String s : l) {
        System.out.println("Item: "+s);
    }


    return Response.status(Response.Status.OK).entity("Salam").build();
}