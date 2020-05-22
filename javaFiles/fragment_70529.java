private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/somepath/tmp/uploaded_files/";

@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
@Path("/upload")
public String uploadFunction(@Context UriInfo uriInfo,
        @FormDataParam("upload") final InputStream inputStream,
        @FormDataParam("upload") final FormDataContentDisposition fileDetail) {

        String filePath = SERVER_UPLOAD_LOCATION_FOLDER + fileDetail.getFileName();
        // save the file to the server
        saveFile(inputStream, filePath);
        String output = "File saved to server location : " + filePath;
        return Response.status(200).entity(output).build();  
}

private void saveFile(InputStream uploadedInputStream, String serverLocation) {
    try {
        OutputStream outputStream = new FileOutputStream(new File(serverLocation));
        int read = 0;
        byte[] bytes = new byte[1024];
        outputStream = new FileOutputStream(new File(serverLocation));
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}