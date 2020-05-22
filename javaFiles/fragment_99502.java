if (ServletFileUpload.isMultipartContent(request)) {                
     List<FileItem> multipart = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

      for (FileItem item : multipart) {
            if (!item.isFormField();
{
      //Your upload file code.
 }
if (item.isFormField()) { 
 
if (item.getFieldName().equals("username")) {
     String id = item.getString();
  }else if (item.getFieldName().equals("email")) {
  String password = item.getString();
        }
}