@Path("/Voices")
public class VoicesOperation {

...

    @Path("/updateVoice")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Voice updateVoice(VoiceBl voice) throws Exception {

        return fillVoicesSnapshot();
    } 
}