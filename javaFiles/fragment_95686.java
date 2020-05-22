@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
public String getFile(@Context HttpServletRequest request, @QueryParam("uid") String uid) {


    ServletFileUpload upload = new ServletFileUpload();
    try {
        FileItemIterator iter = upload.getItemIterator(request);
        while (iter.hasNext()) {
            FileItemStream item = iter.next();
            String name = item.getFieldName();
            InputStream stream = item.openStream();
            if (item.isFormField()) {
                System.out.println("Form field " + name + " with value "
                        + Streams.asString(stream) + " detected.");
            } else {
                System.out.println("File field " + name + " with file name "
                        + item.getName() + " detected.");
                // Process the input stream
              storeFile(stream, uid);
            }
        }

        return "success";

    } catch (FileUploadException ex) {
        Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "failed.";
}