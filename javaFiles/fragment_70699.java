@GET
@Path("/get")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public List<ApplicationDTO> getAllApplications(){
    List<ApplicationDTO> allApplication = applicationService.getAllApplication();
    return allApplication;
}