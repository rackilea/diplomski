@GET
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response downloadFile(String fileName) {
    File file = ... // Find your file
    return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
        .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
        .build();
}