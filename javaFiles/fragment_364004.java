@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileDetail, @QueryParam("fileName") String fileName){
    ...
    ...
    String uploadedFileLocation = SERVER_UPLOAD_LOCATION_FOLDER+ fileName;//fileDetail.getFileName();

    // save it
    saveFile(file, uploadedFileLocation);
    ...

    //Logic of the service.
    ...

    //Delete file from local.
}

private void saveFile(InputStream uploadedInputStream, String serverLocation) throws IOException {

    OutputStream outpuStream=null;
    try {
            outpuStream = new FileOutputStream(new File(serverLocation));
            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();

    } catch( IOException e){
        LOGGER.debug("[UploadWs - saveFile] - error: "+e);
    } finally{
        if(outpuStream!=null){
            outpuStream.close();
        }
    }
}