@POST
@Path("somepath")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFileAndJSON(@FormDataParam("model") FormDataBodyPart jsonPart,
                                  @FormDataParam("file") FormDataBodyPart bodyPart) { 
     jsonPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
     SomeModel model = jsonPart.getValueAs(SomeModel.class);
}