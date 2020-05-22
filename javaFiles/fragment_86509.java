@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
@Path("submit")
public Response submit(@FormDataParam("clientID") String clientID,
                   @FormDataParam("html") String html,
                   @FormDataParam("pdf") InputStream pdfStream) {

    try {
        byte[] pdfByteArray = DocUtils.convertInputStreamToByteArrary(pdfStream);
    } catch (Exception ex) {
        return Response.status(600).entity(ex.getMessage()).build();
    }
}


...

public static byte[] convertInputStreamToByteArrary(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    final int BUF_SIZE = 1024;
    byte[] buffer = new byte[BUF_SIZE];
    int bytesRead = -1;
    while ((bytesRead = in.read(buffer)) > -1) {
        out.write(buffer, 0, bytesRead);
    }
    in.close();
    byte[] byteArray = out.toByteArray();
    return byteArray;
}