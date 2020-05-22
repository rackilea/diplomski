@POST
@Consumes("application/xml")
@Path("/ProjectConfiguration/{onetimetoken}")
public void createProjectConfiguration(@PathParam("onetimetoken") String oneTimeToken,
        CreateProjectConfigurationRequest request) throws IntegratedAppFault 
{
    System.out.println(oneTimeToken);
    System.out.println(request.toString());
}