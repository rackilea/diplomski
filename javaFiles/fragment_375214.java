@Component
@Consumes(MediaType.APPLICATION_JSON)
@Path("/uploadfile")   // THIS IS MANDATORY ANNOTATION
public class FileResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload(@FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition disposition) {
        System.out.println(disposition.getName());

    }

    @GET
    @Path("/foo")
    public String foo() {
        return "foo";
    }
}