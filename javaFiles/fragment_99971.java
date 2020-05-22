@Path("")
public class Rest {
    @POST
    @Path("/rest/upload")
    public String postContent(@Context HttpServletRequest request) {
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator fileIterator = upload.getItemIterator(request);
        while (fileIterator.hasNext()) {
            FileItemStream item = fileIterator.next();
            if ("file".equals(item.getFieldName())){
                byte[] content = IOUtils.toByteArray(item.openStream())
                // Save content into datastore
                // ... 
            } else if ("name".equals(item.getFieldName())){
                String name=IOUtils.toString(item.openStream());
                // Do something with the name string
                // ...
            }
        }
        return "Done";
    } 
}