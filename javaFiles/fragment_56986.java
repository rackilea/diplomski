//code
@POST
@Path("/uploadImage")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(@FormDataParam("file") InputStream uploadedStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail) {
    String fileName = fileDetail.getFileName();
    saveToFile(uploadedStream,fileName);
    String output = "File saved to server location : " + fileName;
    return Response.status(200).entity(output).build();
}