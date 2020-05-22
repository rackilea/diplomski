@POST
@Path("/simpleupload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void simpleUpload(
    //@Context UriInfo ui,
    @Context HttpServletRequest request
){
    String fileRepository = "D:\\";
    if (ServletFileUpload.isMultipartContent(request)) {
    FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List<FileItem> items = null;
    try {
        items = upload.parseRequest(request);
    } catch (FileUploadException e) {
        e.printStackTrace();
    }
    if (items != null) {
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (!item.isFormField() && item.getSize() > 0) {
            System.out.println("File is found.");
            String fileName = processFileName(item.getName());
            try {
                String savePath = fileRepository + fileName;
                System.out.println("savePath:" + savePath);
                item.write(new File(savePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("getFieldName:" + item.getFieldName());
            System.out.println(item.getString());
        }
     }
   }
}
}