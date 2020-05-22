@POST
  @Path("/upload")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces("text/html")
  public Response uploadFile(
      @FormDataParam("username") String username,
      @FormDataParam("password") String password,
      @FormDataParam("title") String title,
      @FormDataParam("file") InputStream fileInputString,
      @FormDataParam("file") FormDataContentDisposition fileInputDetails) {
    String status = null;

    String fileLocation = "/home/user/uploadtest/test.png;
    NumberFormat myFormat = NumberFormat.getInstance();
    myFormat.setGroupingUsed(true);
    // Save the file 
    try {
     OutputStream out = new FileOutputStream(new File(fileLocation));
     byte[] buffer = new byte[1024];
     int bytes = 0;
     long file_size = 0; 
     while ((bytes = fileInputString.read(buffer)) != -1) {
      out.write(buffer, 0, bytes);
      file_size += bytes;
     }
     out.flush();  
     out.close();


     status = "File has been uploaded to:" + fileLocation;
    } catch (IOException ex) {
      System.err.println("Unable to save file: "  + fileLocation);
      ex.printStackTrace();
    }


    return Response.status(200).entity(status).build();
}