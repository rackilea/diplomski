// @GET    <--- Remove this
// @Produces(MediaType.APPLICATION_JSON)
@Path("/{uid:\\d+}")
public PatientResource getPatient(@PathParam("uid") int uid) {
   return new PatientResource(uid);
}