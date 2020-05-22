@Path("/patient")
public class PatientResource {
    @GET @Path("/{patientId}") @Produces(MediaType.TEXT_HTML)
    public Viewable view(@PathParam("patientId") int patientId) {
        return new Viewable("/patient.jsp", Integer.toString(patientId));
    }
}