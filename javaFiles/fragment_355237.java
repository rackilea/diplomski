@POST
@Path("somepath")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFileAndJSON(
         @FormDataParam("model") SomeModel someModel,
         @FormDataParam("file") FormDataBodyPart bodyPart) { 
}