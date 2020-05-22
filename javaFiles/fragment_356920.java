@POST
@Produces("text/plain")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public String uploadFileIE(
    @FormDataParam("qqfile") InputStream uploadedInputStream,
    @FormDataParam("qqfile") FormDataContentDisposition fileDetail){

}