@POST
    @Path("/save/{Name}/{data}")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveDataMap(@QueryParam("number") String number,
    @PathParam("data") String data,
    @PathParam("Name") String appName
    MultivaluedMap<String, String> formParam) throws Exception{
    boolean response =false
    try{
    // some business logic
    response =true
    }

    return Response.ok().entity(String.valueOf(response)).build();
    }