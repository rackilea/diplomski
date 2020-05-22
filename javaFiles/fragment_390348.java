@GET
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response getFile() {
  File file = ... // Initialize this to the File path you want to serve.
  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
      .build();
}