@POST
@Consumes(MediaType.MULTIPART_FORM_DATA_TYPE)
public Response createApp(
  @DefaultValue("true") @FormDataParam("enabled") boolean enabled,
  @FormDataParam("data") FileData bean,
  @FormDataParam("file") InputStream file,
  @FormDataParam("file") FormDataContentDisposition fileDisposition) {

    // your code here
}