@GET
@Path("init")
@Produces({MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
public Response respondAsReady() {
    if(/*condition*/)}
        //In case of a JSON response
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    if(/*condition*/){
        //In case of an integer response
        return Response.ok(text, MediaType.TEXT_PLAIN).build();
    }
}