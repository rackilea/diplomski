@Post
@Consumes("application/octet-stream")
public Representation post(InputStream zip, @HeaderParam(value = "Content-  Disposition") String contentDisposition) throws Throwable {
   System.out.println(contentDisposition); 
   String uploadedFileLocation = getStartingDir() + "/" + "abc.zip";
   writeToFile(zip, uploadedFileLocation); 
   return new StringRepresentation("Uploaded!");
}