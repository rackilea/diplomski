@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces({MediaType.APPLICATION_JSON})
public CreateTaskVO provideService(
               @FormDataParam("meta") String jsonMeta,
               @FormDataParam("data") InputStream file,
               @FormDataParam("data") FormDataContentDisposition fileDetail) {