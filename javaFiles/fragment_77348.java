@Path("/test")
public class ServiceInterface {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void execute(
                   @FormDataParam("someparameter") String param
                   @FormDataParam("inputfile") File inputfile
                       )
    {
        System.out.println(param);
    }
}