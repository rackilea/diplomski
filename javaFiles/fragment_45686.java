@Path("/Voices")
public class VoicesOperation {

...

    @Path("/updateVoice")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response updateVoice(VoiceBl voice) throws Exception {
        Voice voice = fillVoicesSnapshot();
        return Response.status(Status.CREATED)
                       .entity(voice)
                       .build();
    }
}